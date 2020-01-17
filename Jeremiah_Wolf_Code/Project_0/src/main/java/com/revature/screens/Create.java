package com.revature.screens;

import com.revature.pojos.User;
import com.revature.repo.UserRepo;

import java.util.List;
import java.util.Scanner;

public class Create {
    public static void createAccount() {


        String firstName;
        String lastName;
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);


        System.out.println("What is your real First name: ");
        firstName = scanner.nextLine();

        System.out.println("What is your real Last name: ");
        lastName = scanner.nextLine();

        System.out.println("Create a Hero Name: ");
        username = scanner.nextLine();

        System.out.println("Create a Super Secure Password: ");
        password = scanner.nextLine();



        User newUser = new User(firstName, lastName, username, password);

        UserRepo userRepo = new UserRepo();

        List<User> users = userRepo.findAllUsers();
        boolean usernameCheck = false;

        for(User u : users) {

            if(u.getUsername().equals(username)) {

                System.out.println("That hero name has already been taken, Please choose another one.");
                usernameCheck = true;
                createAccount();
                break;

            }

        }
        if (!usernameCheck) {

            userRepo.saveUser(newUser);
            System.out.println("You have been enrolled UA!");
            AcctTrans.accountTransaction(newUser);
        }

    }
}