package com.revature.util;


import com.revature.exceptcions.ScreenNotFoundException;
import com.revature.screens.Screen;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ConnectionFactory {
    private static ConnectionFactory connFactory = new ConnectionFactory();


    private Properties props = new Properties();

    private ConnectionFactory(){
        super();

        try {
            props.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance(){
        return connFactory;
    }

    public Connection getConnection(){
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("admin-user"),
                    props.getProperty("admin-pw")
            );
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();;
        }

        return conn;
    }
}
