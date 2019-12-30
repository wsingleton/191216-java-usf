package com.revature.mockBank;

import java.util.Scanner;

public class Account {
    public static void showBalance() {

        Scanner scanner = new Scanner(System.in);
        // double balance = accountNumber.getBalance();
        //  System.out.println("Your balance is " + balance);


    }
    public static void deposit() {
        //double balance = 0;
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        if (amount > 0) {
            // balance = amount + balance;
        } else {
            System.out.println("Please deposit amount greater than zero.");
        }

    }

    public static void withdraw() {
        // double balance = 0 ;
        System.out.println("Enter withdraw amount: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        if (amount > 0) {
            //balance = balance - amount;
            //System.out.println("Your balance is now : " + balance);

        } else {
            System.out.println("Please withdraw amount greater than zero.");
        }
    }

    public void loginAccount() {

    }

    public void registerAccount() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, userName, password = " ";
        System.out.println("Please enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Please enter last name: ");
        lastName = scanner.nextLine();
        System.out.println("Please enter user name: ");
        userName = scanner.nextLine();
        System.out.println("Please enter password: ");
        password = scanner.nextLine();
    }



    }

