package com.revature;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMain {

    public static void main(String[] args) {

        // Make a file to store the user info
        File takeNames = new File("src/stored/usernames_passwords.txt");

        try (BufferedWriter storing = new BufferedWriter(new FileWriter(takeNames, true))) {

            UserInfo u = new UserInfo(username, password, 0.0);
            storing.write("\n" + u.addToStored());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Ask user to create their username and password
        System.out.println("Please enter your desired username");
        Scanner console = new Scanner(System.in);
        String username = console.nextLine();
        username = username.replaceAll(" ", ""); // stops the spacing bug
        // Checking if the username is blank
        while (username.equals("")) {
            System.out.println("A username is required");
            console = new Scanner(System.in);
            username = console.nextLine();
        }
        // Checking username availability
        try {
            int lineCount = 0;
            String line = "";

            BufferedReader nameCheck = new BufferedReader(new FileReader(takeNames));

            while ((line = nameCheck.readLine()) != null) {
                LineCount++;
                int nameFound = line.indexOf(username);
                if (nameFound > - 1) {
                    System.out.println("This username is already taken");
                    continue;
                }
            }
        }

        /*ArrayList<String> savedNames = new ArrayList<>();

        System.out.println(savedNames);
        for (String name: savedNames) {
            if (name.equals(username)) {
                System.out.println("This username is already taken");
                continue;
            }
        }

        savedNames.add(username);

         */
        
        System.out.println("Please enter your desired password");
        String password = console.nextLine();
        System.out.println("Your username is: " + username + " and your password is: " + password);

    }
}
