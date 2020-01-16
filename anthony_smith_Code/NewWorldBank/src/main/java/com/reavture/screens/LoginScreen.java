package com.reavture.screens;

import com.reavture.repos.UserRepo;

import com.reavture.pojo.*;

import java.util.*;

public class LoginScreen {

    public static void logIn() {

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
        List<User> users = userRepo.findAllUser();

        System.out.println(users);

        for (User u : users) {

            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                checkUser = true;
                DashboardScreen.dashboard(u.getUser_id());
                break;

            }
        }
        if (!checkUser) {

            System.out.println("The username or password is invalid, please try again.");
            System.exit(0);

        }


    }
}
