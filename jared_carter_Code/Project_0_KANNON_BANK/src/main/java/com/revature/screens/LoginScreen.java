package com.revature.screens;

import com.revature.pojos.User;

import java.util.List;
import java.util.Scanner;

public class LoginScreen {
    public static void loginScreen() {

        //Creating a new account
        //set user inputs

        String username;
        String password;
        boolean checkUser = false;

        Scanner scanner = new Scanner(System.in);

        // Ask for username and password
        System.out.println("Enter your username: ");
        username = scanner.nextLine();

        //check username for empty string or null
        if (username.equals("") || username.isEmpty()) {

            System.out.println("Invalid username.");
            loginScreen();

        }

        System.out.println("Enter your password: ");
        password = scanner.nextLine();

        //check password for empty string or null
        if (password.equals("") || password.isEmpty()) {

            System.out.println("Invalid password.");
            loginScreen();

        }

        List<User> users = userRepo.retriveAllUsers();

        for (User u : users) {

            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {

                checkUser = true;
                ExistingUserScreen(u.getId());
                break;

            }

        }
        if (!checkUser) {

            System.out.println("The username or password is invalid, please try again.");
            loginScreen();
        }


    }
}
