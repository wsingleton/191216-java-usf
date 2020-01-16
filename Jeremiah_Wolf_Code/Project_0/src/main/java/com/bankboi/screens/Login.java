package com.bankboi.screens;

import com.bankboi.plainjava.Users;
import com.bankboi.repos.userrepo;

import java.util.List;
import java.util.Scanner;

public class Login {

    public static void logIn() {



        String username;
        String password;
        boolean checkUser = false;

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your username: ");
        username = scanner.nextLine();


        if (username.equals("") || username.isEmpty()) {

            System.out.println("Invalid username.");
            logIn();

        }

        System.out.println("Enter your password: ");
        password = scanner.nextLine();


        if (password.equals("") || password.isEmpty()) {

            System.out.println("Invalid password.");
            logIn();

        }
        userrepo userRepo = new userrepo();
        List<Users> users = userRepo.findAllUsers();

        for (Users u : users) {

            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                checkUser = true;

                Existing.existingUserScreen(u.getId());
                break;

            }

        }
        if (!checkUser) {

            System.out.println("The username or password is invalid, please try again.");
            System.exit(0);

        }


    }
}