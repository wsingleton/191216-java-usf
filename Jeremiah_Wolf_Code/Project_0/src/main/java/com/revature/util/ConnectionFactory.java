package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();
    private Properties prop = new Properties();

    private ConnectionFactory() {
        super();
        try {
            prop.load(new FileReader("./src/main/resources/application.properties"));
        } catch(IOException e) { e.printStackTrace(); }
    }

    public static synchronized ConnectionFactory getInstance() {

        if(connFactory == null) connFactory = new ConnectionFactory();

        return connFactory;

    }


    public Connection getConnection() {

        Connection conn = null;



        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            conn = DriverManager.getConnection(
                    prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("passw"));

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return conn;

    }
}