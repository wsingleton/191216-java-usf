package com.revature.quizzard.util;

import com.revature.quizzard.models.Role;
import com.revature.quizzard.models.User;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private Properties props = new Properties();

    private ConnectionFactory() {
        super();

        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
          //  props.load(new FileReader("./src/main/resources/application.properties"));
            InputStream input = loader.getResourceAsStream("application.properties");
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConnectionFactory getInstance() {
        return connFactory;
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
