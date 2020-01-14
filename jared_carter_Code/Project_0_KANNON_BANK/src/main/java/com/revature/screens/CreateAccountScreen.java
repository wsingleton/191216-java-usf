package com.revature.screens;

import com.revature.pojos.User;
import com.revature.repo.UserRepo;

import java.util.List;
import java.util.Scanner;

public class CreateAccountScreen {
    public static void createAccount() {

        //User fields

        String firstName;
        String lastName;
        String username;
        String password;


        Scanner scanner = new Scanner(System.in);

        //---------------- Ask for user info ----------------

        System.out.println("First name: ");
        firstName = scanner.nextLine();

        System.out.println("Last name: ");
        lastName = scanner.nextLine();

        System.out.println("Create a username: ");
        username = scanner.nextLine();

        System.out.println("Create a password: ");
        password = scanner.nextLine();



        User newUser = new User(firstName, lastName, username, password);

        //Check DB if username exists
        //get list of users
        UserRepo userRepo = new UserRepo();

        List<User> users = userRepo.findAllUsers();
        boolean usernameCheck = false;

        for(User u : users) {

            if(u.getUsername().equals(username)) {

                System.out.println("Username already taken. Please choose another one.");
                usernameCheck = true;
                createAccount();
                break;

            }

        }
        if (!usernameCheck) {

            userRepo.saveUser(newUser);
            System.out.println("You have created an account.");
            AccountTransactionScreen.accountTransaction(newUser);
        }

    }
}
