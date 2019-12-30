package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.System;

public class RegisterUser {

    public static void registerUser() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("registering the user");
        System.out.println("Enter firstName");
        String firstName = input.next();
        System.out.println("Enter lastName");
        String lastName  = input.next();
        System.out.println("Enter username: ");
        String username = input.next();
        System.out.println("Enter your password:");
        String password = input.next();

        File userFile = new File("resources\\users.txt");
        File accountFile = new File("resources\\accounts.txt");

        try(BufferedWriter userWriter = new BufferedWriter(new FileWriter(userFile, true))) {
            User user = new User(password, username, firstName, lastName);
            userWriter.write(user.toString());

            Accounts accounts = new Accounts(0.0, username);
            BufferedWriter accountWriter = new BufferedWriter(new FileWriter(accountFile, true));
            System.out.println("toString: " + accounts.toString());
            accountWriter.write(accounts.toString());
            Logon.logon();

        } catch (Exception e){
            registerUser();
        }

           return;
    }


}
