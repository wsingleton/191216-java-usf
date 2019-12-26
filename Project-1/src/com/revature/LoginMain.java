package com.revature;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class LoginMain {

    public static void main(String[] args) {


        //Ask user to create their username and password
        System.out.println("Please enter your desired username");
        Scanner console = new Scanner(System.in);
        String username = console.nextLine();
        username = username.replaceAll(" ", ""); // stops the spacing bug
        // Check for entering nothing
        while (username.equals("")) {
            System.out.println("A username is required");
            console = new Scanner(System.in);
            username = console.nextLine();
        }

        System.out.println("Please enter your desired password");
        String password = console.nextLine();



        // Make a file to store the user info
        File takeNames = new File("src/stored/usernames_passwords.txt");

        try (BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames, true))) {

            UserInfo u = new UserInfo(username, password, 0.0);
            storing.write("\n" + u.addToStored());

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Your username is: " + username + " and your password is: " + password);


    }
}
