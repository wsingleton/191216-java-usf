package com.revature.ers.utils;

import com.revature.ers.models.Role;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private Properties props = new Properties();

    private ConnectionFactory() {
        super();

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("application.properties");
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() { return connFactory; }

    public Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("un"),
                    props.getProperty("pw")
            );

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

    public Connection getConnection(Role role) {

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            switch(role) {
                case EMPLOYEE:
                    conn = DriverManager.getConnection(
                            props.getProperty("url"),
                            props.getProperty("emp_un"),
                            props.getProperty("emp_pw")
                    );
                    break;
                case MANAGER:
                    conn = DriverManager.getConnection(
                            props.getProperty("url"),
                            props.getProperty("man_un"),
                            props.getProperty("man_pw")
                    );
                    break;
                default:
                    conn = null;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }
}
