package com.revature.bank.util;

import java.io.FileReader;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();

    private Properties props = new Properties();

    private ConnectionFactory(){
        super();

        try{
            props.load(new FileReader(""))
        }
    }
}
