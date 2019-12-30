package com.revature;

import java.util.Scanner;

public class Account {

    static Scanner scanner = new Scanner(System.in);
    private double accountBalance;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;


    Account(){
        accountNumber = numberOfAccounts++;

    }


    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    public static void getAccountBalance(double accountBalance) {

        System.out.println("Your account balance is: "+ accountBalance);

    }


    public static double withdraw(double accountBalance) {

        System.out.println("How much would you like to withdraw ?");
        double amount = scanner.nextDouble();
        accountBalance = accountBalance - amount;
        return accountBalance;

    }

    public static double deposit(double accountBalance) {

        System.out.println("How much do you want to deposit ?");
        double amount =  scanner.nextDouble();
        accountBalance = accountBalance + amount;
        return accountBalance;
    }

    public static void displayBalance() {
        System.out.println("You're Balling");
    }


//    int accountNumber = ++100000;

}