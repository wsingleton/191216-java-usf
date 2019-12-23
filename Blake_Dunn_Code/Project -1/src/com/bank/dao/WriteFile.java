package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.*;

public class WriteFile {

    private String path;
    private boolean appendToFile = false;


    public WriteFile(String filePath, boolean appendValue) {
        path = filePath;
        appendToFile = appendValue;
    }

    public static void writeToUserFile(User newUser) {

        final String filePath =
                "C:/Users/bdunn/OneDrive/Desktop/repos/191216-java-usf/Blake_Dunn_Code/Project -1/Users.txt";

        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(newUser);
            objectOut.close();
            System.out.println("You have successfully registered an account!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void writeToAcctFile(Account newUser) {

        final String filePath =
                "C:/Users/bdunn/OneDrive/Desktop/repos/191216-java-usf/Blake_Dunn_Code/Project -1/Accounts.txt";

        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(newUser);
            objectOut.close();
            System.out.println("You have successfully created an account!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
