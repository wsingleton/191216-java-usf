package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.revature.MockBankDriver.router;

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    private Properties props = new Properties();
    private static Connection con;

    private ConnectionFactory(){
        super();
        try{
            props.load(new FileReader("./resources/application.properties"));
        }catch (IOException e){
            System.out.println("Issue retrieving credentials for database.");
            router.navigate("/home");
        }
        con = createConnection();
    }

    public static Connection getCon(){ return con; }

    public ConnectionFactory getInstance(){
        return connectionFactory;
    }

    public Connection createConnection(){
        try {
            String className = "oracle.jdbc.driver.OracleDriver";
            Class.forName(className);
            con = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("user"),
                    props.getProperty("pw"));
            return con;
        }catch (SQLException sqlE){
            System.out.println("Error in SQL syntax!");
        }catch (ClassNotFoundException cnfe){
            System.out.println("Driver not found!");
        }
        return null;
    }
}
