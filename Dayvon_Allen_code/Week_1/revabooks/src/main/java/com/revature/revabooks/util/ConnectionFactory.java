package com.revature.revabooks.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private ConnectionFactory(){
        super();
    }

    public static  ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection(){

        Connection conn = null;

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@database-1.cukhca6vkixv.us-east-2.rds.amazonaws.com:1521:ORCL",
                    "rbs_app", "p4ssw0rd");

        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

}
