package com.bankboi.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class InternetConnection {

    private static InternetConnection netConn = new InternetConnection();
    private Properties prop = new Properties();

    private InternetConnection() {
        super();
        try {
            prop.load(new FileReader("./src/main/resources/application.properties"));
        } catch(IOException e) { e.printStackTrace(); }
    }

    public static synchronized InternetConnection getInstance() {

        if(netConn == null) netConn = new InternetConnection();

        return netConn;

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
