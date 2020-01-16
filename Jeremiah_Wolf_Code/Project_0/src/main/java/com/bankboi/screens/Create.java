package com.bankboi.screens;

import com.bankboi.plainjava.Users;
import com.bankboi.repos.userrepo;

import java.util.List;
import java.util.Scanner;

    public class Create{
        public static void createAccount() {


            String firstName;
            String lastName;
            String username;
            String password;
            Scanner scanner = new Scanner(System.in);


            System.out.println("First name: ");
            firstName = scanner.nextLine();

            System.out.println("Last name: ");
            lastName = scanner.nextLine();

            System.out.println("Create a username: ");
            username = scanner.nextLine();

            System.out.println("Create a password: ");
            password = scanner.nextLine();



            Users newUser = new Users(firstName, lastName, username, password);

            userrepo userRepo = new userrepo();

            List<Users> users = userRepo.findAllUsers();
            boolean usernameCheck = false;

            for(Users u : users) {

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
                AcctTrans.accountTransaction(newUser);
            }

        }
    }

