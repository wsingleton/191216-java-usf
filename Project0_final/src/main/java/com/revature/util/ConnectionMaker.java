package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMaker {

    private static ConnectionMaker connection = new ConnectionMaker();

    private ConnectionMaker() {
        super();
    }

    public static ConnectionMaker getInstance() {
        return connection;
    }

    public Connection liveConnection() {

        Connection connection = null;

         try {
             Class.forName("oracle.jdbc.driver.OracleDriver");

             connection =
                     DriverManager.getConnection("jdbc:oracle:thin:@niles-db.cgbvd9f8ntqe.us-east-2.rds.amazonaws.com:1521:ORCL","banking_app", "p4ssw0rd");

         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }

         return connection;
    }

}
