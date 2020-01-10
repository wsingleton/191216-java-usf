package com.revature.revabooks.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.OptionalDouble;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory connFactory = new ConnectionFactory();
    private Properties props = new Properties();

    public ConnectionFactory() {
        super();

        try{
            props.load(new FileReader("./src/main/resources/application.properties"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ConnectionFactory  getInstance(){
        return connFactory;
    }

    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@bosco-db.ccuh9npdivlz.us-east-2.rds.amazonaws.com:1521:ORCL",
//                    "revabooks_user", "p4ssw0rd");
            con = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("user"),
                    props.getProperty("password")
            );

        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
