package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;
import java.util.InputMismatchException;
import java.util.Scanner;


import static com.bank.dao.WriteFile.writeToAccount;
import static com.bank.dao.WriteFile.writeToUser;
import static com.bank.service.UserService.*;

public class UserScreen extends User {

    public static void homeScreen() {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Faux Bank");
        System.out.println("To sign in, press 0");
        System.out.println("To create an account, press 1:  ");
        int number = input.nextInt();

        if (number == 0){
            login();
        }
        else if (number == 1){
            register();
        }
        else{
            System.out.println("Error: Please press 0 or 1");
            homeScreen();
        }

    }

    public static void register() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username (Must be at least 8 characters and no more than 14: " );
        String un = scanner.next();
        validateUserName(un);
        System.out.println("");
        System.out.print("Password (must contain a special character): " );
        String pw = scanner.next();
        validatePassword(pw);
        System.out.println("");
        System.out.print("First name: " );
        String fn = scanner.next();
        validateNames(fn);
        System.out.println("");
        System.out.print("Last name: " );
        String ln = scanner.next();
        validateNames(ln);
        System.out.println("");

        int newId = createId();

        User newUser = new User(newId, un, pw, fn, ln);
        System.out.println(newUser);

        writeToUser(newUser);

        System.out.println("Thank you!");
        System.out.print("Please enter the amount you'd like to deposit: ");
        double bal = scanner.nextDouble();

        Account newAcct = new Account(newId, bal);
        writeToAccount(newAcct);

        display(newAcct);

    }



    public static void login() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String un = scanner.next();
        System.out.println("");

        System.out.print("Password: ");
        String pw = scanner.next();




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

            checkBalance(acct);
        }
        else if(number == 1){

            deposit(acct);
        }
        else if(number == 2){

            withdraw(acct);
        }
        else{

            System.out.println("Error: Please try again");
            System.out.println("");
            display(acct);
        }

    }

    public static void withdraw(Account acct) {


        double bal = acct.getBalance();
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the withdrawal amount: ");

        double amount = 0;
        try {
            amount = input.nextDouble();
        }catch (InputMismatchException e) {
            System.out.println("Invalid value");
            withdraw(acct);
        }

        if(amount > bal) {

            System.out.println("Sorry, no overdrafts allowed.");
            System.out.println("Please try again");
            withdraw(acct);
        }
        else {

        bal -= amount;
        acct.setBalance(bal);

        }

        System.out.println("Your new balance is $" + bal);
        System.out.println("Would you like to perform another transaction?");
        System.out.print("1 = Yes, 0 = No: ");

        int num = 0;
        try{
            num = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
            System.exit(0);
        }

        if(num == 1) {
            display(acct);
        }
        else {
            System.exit(num);
        }
    }

    public static void checkBalance(Account acct){

        Scanner scanner = new Scanner(System.in);
        double bal = acct.getBalance();

        System.out.println("");
        System.out.println("Your Balance: $" + bal);

        System.out.println("Would you like to perform another transaction?");
        System.out.print("1 = Yes, 0 = No: ");
        int num = 0;
        try{
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
            System.exit(0);
        }

        if(num == 1) {
            display(acct);
        }
        else {
            System.exit(num);
        }

    }

    public static void deposit(Account acct) {


        double bal = acct.getBalance();
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("Your Account Balance: $" + bal);
        System.out.print("Enter the deposit amount: ");
        double amount = 0;
        try {
            amount = input.nextDouble();
        }catch (InputMismatchException e) {
            System.out.println("Invalid value");
            deposit(acct);
        }

        bal += amount;
        acct.setBalance(bal);

        System.out.println("Your new balance is $" + bal);
        System.out.println("Would you like to perform another transaction?");
        System.out.print("1 = Yes, 0 = No: ");

        int num = 0;
        try{
            num = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
            System.exit(0);
        }

        if(num == 1) {
            display(acct);
        }
        else {
            System.exit(num);
        }

    }
}
