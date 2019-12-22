package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;


import java.util.Scanner;


public class UserScreen extends User {

    public static void homeScreen() {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Faux Bank");
        System.out.println("To sign in, press 0");
        System.out.println("To create an account, press 1 ");

        int number = input.nextInt();

        if (number == 0){

            login();
        }
        else if (number == 1){

            register();
        }
        else{

            System.out.println("Error: Please press 0 or 1");
        }

    }

    public static void register() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("First name: " );
        String fn = scanner.next();
        System.out.println("");
        System.out.print("Last name: " );
        String ln = scanner.next();
        System.out.println("");
        System.out.print("Username: " );
        String un = scanner.next();
        System.out.println("");
        System.out.print("Password: " );
        String pw = scanner.next();
        System.out.println("");
        int newId = createId();

        User newUser = new User(newId, fn, ln, un, pw);

        System.out.println("Thank you!");
        System.out.print("Please enter the amount you'd like to deposit: ");
        double bal = scanner.nextDouble();

        Account newAcct = new Account(newId, bal);

        display(newAcct);

    }


    public static void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String input = scanner.next();
        System.out.println("");

        System.out.print("Password: ");
        String input2 = scanner.next();

        // display();

    }

    public static void display(Account acct) {

        Scanner input = new Scanner(System.in);

        System.out.println("Check Balance = 0");
        System.out.println("Deposit = 1");
        System.out.println("Withdraw = 2");
        System.out.print("Please choose an option: ");
        int number = input.nextInt();

        if (number == 0){

            acct.checkBalance(acct);
        }
        else if(number == 1){

            acct.deposit(acct);
        }
        else if(number == 2){

            acct.withdraw(acct);
        }
        else{

            System.out.println("Error: Please try again");
            System.out.println("");
            acct.display(acct);
        }

    }

    public void withdraw(Account acct) {


        double bal = acct.getBalance();
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the withdrawal amount: ");
        double amount = input.nextDouble();

        bal -= amount;
        acct.setBalance(bal);
    }

    public void checkBalance(Account acct){

        Scanner scanner = new Scanner(System.in);
        double bal = acct.getBalance();

        System.out.println("");
        System.out.println("Your Balance: $" + bal);

        System.out.println("To go back to the Home Screen, press 0");
        System.out.println("To sign out, press 1");

    }

    public void deposit(Account acct) {


        double bal = acct.getBalance();
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("Your Account Balance: $" + bal);
        System.out.print("Enter the deposit amount: ");
        double amount = input.nextDouble();

        bal += amount;
        acct.setBalance(bal);

    }
}
