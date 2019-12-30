package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bank {

    public static void main(String[] args) {

        Set<User> userSet = new Set<User>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\tWelcome to Tony's Bank Application\n\n");

        System.out.println("\tPlease make a selection\n");

        System.out.println("1.\t Login ");
        System.out.println("2.\t Create a new account ");
        System.out.println("3.\t Exit");

        int choice = scanner.nextInt();
        System.out.println(choice);

        userMenu(choice);
        
    }

    public static void userMenu(int option){

        switch (option){

            case 1:
                login();
                break;

            case 2:
                createNewUser();
                break;

            case 3:
                System.exit(0);
                break;

            default:
                System.out.println("You enter a invalid selection. Please try again");
        }

    }

    private static void  createNewUser() {

            Scanner myObj = new Scanner(System.in);

            System.out.println("Pleas enter you name first name");
            String userFirstName = myObj.nextLine();
            System.out.println(userFirstName);

            System.out.println("Pleas enter you name last name");
            String userLastName = myObj.nextLine();
            System.out.println(userLastName);

            System.out.println("Please enter a user name");
            String userName= myObj.nextLine();
            System.out.println(userName);

            System.out.println("Please create an password");
            String userPassword = myObj.nextLine();
            System.out.println(userPassword);

            System.out.println("You must an intial deposit. Please enter the amount you wish to deposit");
            Double startingBalance = myObj.nextDouble();

            User user = new User(userLastName, userFirstName, userName, userPassword,startingBalance);

        }

    private static void login() {
        System.out.println("login current user");
        System.out.println("validate username & password");


        //if statement to validate user called method to display banking operations


        bankingOperations();

    }


    public static void bankingOperations(){

        System.out.println("\tPlease make a selection\n");

        System.out.println("1.\t Withdraw");
        System.out.println("2.\t Deposit");
        System.out.println("3.\t Display Balance");
        System.out.println("4.\t Exit");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option){

            case 1:
                Account.withdraw(userSet.accountBalance);
                break;

            case 2:
                Account.deposit(userSet.accountBalance);
                break;

            case 3:
                Account.displayBalance(userSet.accountBalance);
                break;

            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("You selected an invalid selection. Please try again.");

        }


    }

}

