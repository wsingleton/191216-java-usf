package com.revature.bank2.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;



import java.util.Properties;


public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private ConnectionFactory() {
        super();


    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }




    public Connection getConnection(){

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return conn;
    }
}
