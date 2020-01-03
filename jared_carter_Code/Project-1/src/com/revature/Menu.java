package com.revature;

import java.sql.SQLOutput;
import java.util.Hashtable;
import java.util.Scanner;

public class Menu {

    private Hashtable<Integer, Account> acctBase = new Hashtable<>();

    // setting initial balance to 0.
   double  balance = 0;
   int option = 0;
   // Will be using Scanner a lot so making instantiating in the class scope. So everyone has access to it.
    Scanner scanner = new Scanner(System.in);
    public void loginMenu(){
        System.out.println("---------------------------");
        System.out.println("Kannon's Bank.");
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

            }
            System.out.println("****************************");

            switch (option) {
                case 1:
                    makingNewAccount();

                    break;
                case 2:
                    register();

                case 3:
                    System.out.println("Thank you for using Kannon's Bank.");
                    System.exit(0);
                default:
                    System.out.println("Invalid entry, please try again");
            }
        }
        while (option != 3) ;
    }

    public void transactionMenu() {



        System.out.println("---------------------------");
        System.out.println("1: Make a deposit");
        System.out.println("2: Make a withdraw");
        System.out.println("3: View balance");
        System.out.println("4: Exit");
        System.out.println("---------------------------");

        do {


            System.out.println("Enter an option");
            try {
                option = Integer.parseInt(scanner.nextLine());
            }

            catch(Exception e){
                System.out.println("Please select a number: ");

            }
            System.out.println("****************************");

            switch (option) {
                case 1:
                    viewBalance();

                    break;
                case 2:
                  deposit();

                    break;
                case 3:
                    withdraw();

                case 4:
                    System.out.println("Thank you for using Kannon's Bank.");
                    System.exit(0);
                default:
                    System.out.println("Invalid entry, please try again");
            }
        }
        while (option != 4) ;


    }


    private void viewBalance() {

        System.out.println("Your current balance is $ "+ balance);
        loginMenu();
    }

    private void withdraw() {

        boolean valid = false;
        double withdraw = 0;
        System.out.println("Please enter withdraw amount: ");
        while (!valid) {
            try {
                withdraw = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a number: ");
            }
            if (withdraw < balance +1) {
                balance = balance - withdraw;
                valid = true;
            } else {
                //So they do not get stuck in infinite loop if they have zero dollars.
                System.out.println("You do not have enough to withdraw: ");
                loginMenu();
            }


        }
        transactionMenu();
    }


    private void deposit() {
        boolean valid = false;
        double deposit = 0;
        System.out.println("Please enter deposit amount: ");
        while (!valid) {
            try {
                deposit = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a number: ");
            }
            if (deposit > 0) {
                balance = deposit + balance;
                valid = true;
            } else {

                System.out.println("Please deposit amount greater than zero.");
                //May get stuck in infinite loop if do not have any more to deposit.
                loginMenu();
            }


        }
        transactionMenu();
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
                    balance = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Please enter a number: ");

                }
                if (balance < 0) {
                    System.out.println("Please enter a positive number: ");

                } else {
                    valid = true;
                }

            }
            transactionMenu();


            //Account account = new Checking(balance);

        }

    private void register() {


    }

    }

