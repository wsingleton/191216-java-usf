package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.bank.ui.UserScreen.display;
import static com.bank.ui.UserScreen.register;

public class ReadFile {


    public static void checkRegister(String userName, String password) {

        File userFile = new File("src/resources/users.txt");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                String[] token = line.split(":");
                if (token[1].equals(userName) && token[2].equals(password)) {
                    System.out.println("Sorry, that login is already taken.");
                    System.out.println("");
                    register();
                }
            }

        }catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }

        System.out.println("You have successfully registered with Faux Bank!");
    }

    public static void checkLogin(String userName, String password) {

        File userFile = new File("src/resources/users.txt");
        File acctFile = new File("src/resources/account.txt");

        try {

            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            BufferedReader reader2 = new BufferedReader(new FileReader(acctFile));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                String[] token = line.split(":");
                if (token[1].equals(userName) && token[2].equals(password)) {
                    System.out.println("Login successful.");
                    String token1 = token[0];
                    while (line != null) {
                        line = reader2.readLine();
                        String[] token2 = line.split(":");
                        if(token2[0].equals(token1)){
                            Integer token3 = new Integer(token2[0]);
                            Double token4 = new Double(token2[1]);
                            Account newAcct = new Account(token3, token4);
                            display(newAcct);

                        }
                    }
                }
            }

        }catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }


    }


}
