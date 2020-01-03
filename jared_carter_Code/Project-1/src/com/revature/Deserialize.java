package com.revature;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class Deserialize {



    public static void fillMap(Hashtable map) {

        int accountNumber = 0;
        String username = "";
        String password = "";
        double balance = 0;

        String format = accountNumber + " " + username + " " + password + " " + balance;

        File file = new File("C:\\Users\\Jared\\repos\\191216-java-usf\\jared_carter_Code\\Project-1\\src\\users");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while(scanner.hasNext()) {
                accountNumber = scanner.nextInt();
                username = scanner.next();
                password = scanner.next();
                balance = scanner.nextDouble();
                Account fill = new Account(username, password, accountNumber, balance);
                map.put(accountNumber, fill);
            }
        }
        catch(Exception e) {
            System.out.println("Exception");
        }
    }
}
