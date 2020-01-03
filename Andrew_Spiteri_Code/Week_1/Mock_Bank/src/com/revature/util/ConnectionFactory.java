package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionFactory {

    public static Connection createConnection(){
        try {
            String className = "oracle.jdbc.driver.OracleDriver";
            Class.forName(className);
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "M1ch1gan");
            return con;
        }catch (SQLException sqlE){
            System.out.println("Error in SQL syntax!");
        }catch (ClassNotFoundException cnfe){
            System.out.println("Driver not found!");
        }
        return null;
    }
}
