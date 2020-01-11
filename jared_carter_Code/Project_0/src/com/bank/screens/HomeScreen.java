package com.bank.screens;

import com.bank.models.Account;

import java.util.Scanner;

public class HomeScreen {
    TransactionScreen ts = new TransactionScreen();
    int option = 0;
    boolean success = false;
    double balance = 0;
    Scanner scanner = new Scanner(System.in);
    public void loginMenu(){
        System.out.println("---------------------------");
        System.out.println("Bank.");
        System.out.println("1: Make an account");
        System.out.println("2: Sign in");
        System.out.println("3: Exit");
        System.out.println("---------------------------");

        do {


            System.out.println("Enter an option");
            try {
                option = Integer.parseInt(scanner.nextLine());
            }

            catch(Exception e){
                System.out.println("Please select a number: ");
                System.exit(0);
            }
            System.out.println("****************************");

            switch (option) {
                case 1:
                    makingNewAccount();

                    break;
                case 2:

                    signIn();
                    break;
                case 3:
                    System.out.println("Thank you for using Bank.");

                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid entry, please try again");
            }
        }
        while (false) ;
        System.out.println("Invalid username or password.");
    }


    private void makingNewAccount(){
        String userName, password, accountNumber;
        double initialDeposit = 0;
        System.out.println("Enter a username: ");
        userName = scanner.nextLine();
        System.out.println("Enter a password: ");
        password = scanner.nextLine();
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter an initial deposit: ");
            try {
                String dummy = scanner.next();
                balance = Double.parseDouble(dummy);
            } catch (Exception e) {
                System.out.println("Please enter a number: ");

            }
            if (balance < 0) {
                System.out.println("Please enter a positive number: ");

            } else {
                valid = true;
            }

        }

//        acctBase.put(userName,new Account(userName,password,balance) );
//        token = userName;
//        ts.transactionMenu();



    }

    public void signIn() {
        System.out.println("Enter Username: ");
        String username = scanner.next();
        System.out.println("Enter Password: ");
        String password = scanner.next();

//        if (acctBase.containsKey(username) && acctBase.get(username).getPassword().equals(password)) {
//            success = true;
//            token = username;
//            balance = acctBase.get(username).getBalance();
//            ts.transactionMenu();
//        }
    }
}
