package com.revature.screens;

import com.revature.pojos.User;
import com.revature.repo.UserRepo;

import java.util.List;
import java.util.Scanner;

public class Login {

    public static void logIn() {



        String username;
        String password;
        boolean checkUser = false;

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your Hero Name: ");
        username = scanner.nextLine();


        if (username.equals("") || username.isEmpty()) {

            System.out.println("That is not your Hero Name.");
            logIn();

        }

        System.out.println("Enter your Super Secure Password: ");
        password = scanner.nextLine();


        if (password.equals("") || password.isEmpty()) {

            System.out.println("Invalid Super Secure Password.");
            logIn();

        }
        UserRepo userRepo = new UserRepo();
        List<User> users = userRepo.findAllUsers();

        for (User u : users) {

            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                checkUser = true;

                Existing.existingUserScreen(u.getId());
                break;

            }

        }
        if (!checkUser) {

            System.out.println("The Hero Name or Super Secure Password is invalid, you better not be an evil villian");
            System.exit(0);

        }


    }
}