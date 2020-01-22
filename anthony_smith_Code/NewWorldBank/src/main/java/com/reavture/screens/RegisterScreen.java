package com.reavture.screens;

import java.util.*;

import com.reavture.repos.*;
import com.reavture.pojo.*;

public class RegisterScreen {

    public static void createAccount() {

        //User fields

        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String email = "";
        Scanner scanner = new Scanner(System.in);


        System.out.println("Create a username: ");
        username = scanner.next();

        System.out.println("Enter your email: ");
        email = scanner.next();

        System.out.println("Last name: ");
        lastName = scanner.next();

        System.out.println("First name: ");
        firstName = scanner.next();

        System.out.println("Create a password: ");
        password = scanner.next();


        User newUser = new User(username, email, lastName, firstName, password);

//        System.out.println(newUser);


        UserRepo userRepo = new UserRepo();

        List<User> users = userRepo.findAllUser();
        boolean usernameCheck = false;

        for (User u : users) {

            if (u.getUsername().equals(username)) {

                System.out.println("Username already taken. Please choose another one.");
                usernameCheck = true;
                createAccount();
                break;

            }

        }
        if (!usernameCheck) {

            userRepo.saveUser(newUser);
            System.out.println("You have created an account.");

            BankRepo bankRepo = new BankRepo();
            Account account = new Account();
            System.out.println(newUser.getUser_id());
            account.setUser_id(newUser.getUser_id());
            System.out.println("account.getUser = " + account.getUser_id());
            bankRepo.saveAccountBank(account);

            DashboardScreen.dashboard(newUser.getUser_id());





        }

    }
}