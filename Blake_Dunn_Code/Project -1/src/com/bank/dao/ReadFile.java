package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {


    public static void readUserFile(User newUser) {

        File userFile = new File("src/resources/users.txt");
        System.out.println("Does the file exist? ::" + userFile.exists());

        try {

            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
            }

        }catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }
    }

    public static void readAccountFile(int id) {

        File userFile = new File("src/resources/account.txt");
        System.out.println("Does the file exist? ::" + userFile.exists());

        try {

            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
            }

        }catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        }catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }


    }


}
