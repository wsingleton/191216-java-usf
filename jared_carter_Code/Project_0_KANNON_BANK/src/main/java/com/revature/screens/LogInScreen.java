package com.revature.screens;

import com.revature.pojos.User;
import com.revature.repo.UserRepo;

import java.util.List;
import java.util.Scanner;

public class LogInScreen {

    public static void logIn() {

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
            logIn();

        }

        System.out.println("Enter your password: ");
        password = scanner.nextLine();

        //check password for empty string or null
        if (password.equals("") || password.isEmpty()) {

            System.out.println("Invalid password.");
            logIn();

        }
        UserRepo userRepo = new UserRepo();
        List<User> users = userRepo.findAllUsers();

        for (User u : users) {

            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                checkUser = true;



                ExistingUserScreen.existingUserScreen(u.getId());
                break;

            }

        }
        if (!checkUser) {

            System.out.println("The username or password is invalid, please try again.");
            System.exit(0);
            //logIn();
        }


    }
}
