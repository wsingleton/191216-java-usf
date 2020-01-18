package com.revature.ers.util;

import com.revature.ers.models.Role;
import com.revature.ers.models.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private Properties props = new Properties();

    private ConnectionFactory() {
        super();

        try{
            props.load(new FileReader("./src/main/resources/application.properties"));
        }catch (IOException e) {
            e.printStackTrace();
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

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("admin-usr"),
                    props.getProperty("admin-pw")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
