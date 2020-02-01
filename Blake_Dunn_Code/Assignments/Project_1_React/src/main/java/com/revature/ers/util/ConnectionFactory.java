package com.revature.ers.util;

import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();
    private static final Logger LOG = LogManager.getLogger(ConnectionFactory.class);
    private Properties props = new Properties();

    private ConnectionFactory() {
        super();

        try{
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("application.properties");
            props.load(input);
        }catch (IOException e) {
            LOG.warn(e.getMessage());
        }
    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection(User sessionUser) {

        Role userRole = sessionUser.getRole();
        Connection conn = null;

        try {
            switch(userRole) {
                case ADMIN:
                case MANAGER:
                    conn = DriverManager.getConnection(
                            props.getProperty("url"),
                            props.getProperty("admin-usr"),
                            props.getProperty("admin-pw")
                    );
                    break;
                case EMPLOYEE:
                    conn = DriverManager.getConnection(
                            props.getProperty("url"),
                            props.getProperty("usr"),
                            props.getProperty("pw")
                    );
            }
        }catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return conn;
    }

    public Connection getConnection() {
        LOG.info("Attempting to establish connection to the database.");
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("admin-usr"),
                    props.getProperty("admin-pw")
            );


        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(e.getMessage());
        }
        LOG.info("Connection to database was successful!");
        return conn;
    }
}