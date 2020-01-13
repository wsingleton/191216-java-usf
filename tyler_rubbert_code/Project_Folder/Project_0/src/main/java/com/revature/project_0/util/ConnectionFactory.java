package com.revature.project_0.util;

import com.revature.project_0.models.User;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory = new ConnectionFactory();

    private Properties props = new Properties();

    private ConnectionFactory() {
        super();

        try {
            props.load(new FileReader(".src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConnectionFactory getInstance() {

        return connectionFactory;

    }

    public Connection getConnection(User sessionUser) {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("usr"),
                    props.getProperty("pw")
            );
        } catch (SQLException sqle) {
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
                    props.getProperty("usr"),
                    props.getProperty("pw")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

}
