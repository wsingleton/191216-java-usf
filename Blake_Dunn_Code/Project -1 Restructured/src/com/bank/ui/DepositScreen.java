package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bank.dao.AccountDao.replaceBalance;

public class DepositScreen extends User {

    public static void deposit(Account acct) {

        double bal = acct.getBalance();
        double newBalance = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("Your Account Balance: $" + bal);
        System.out.print("Enter the deposit amount: ");
        double amount = 0;
        try {
            amount = input.nextDouble();

            if(amount < 0){
                System.out.println("You're a dumbass, try again!!");
                deposit(acct);
            }else {
                newBalance = bal + amount;
                acct.setBalance(newBalance);
                int oldAcct =  acct.getiD();
                String oldAcctBal = Double.toString(bal);
                String oldAcctNum = Integer.toString(oldAcct);
                String newAcctNum = Integer.toString(oldAcct);
                String newAcctBal = Double.toString(newBalance);
                replaceBalance(oldAcctNum, oldAcctBal, newAcctNum, newAcctBal);
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid value");
            deposit(acct);
        }
        System.out.println("Your new balance is $" + newBalance);
        System.out.println("Would you like to perform another transaction?");
        System.out.print("1 = Yes, 0 = No: ");
        newTransaction(acct, input);
    }

    public static void newTransaction(Account acct, Scanner input) {
        int num = 0;
        try{
            num = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
            // Update balance in account file method
            System.exit(0);
        }
        if(num == 1) {
            MainScreen.display(acct);
        }
        else {
            // Update balance in account file method
            System.exit(num);
        }
    }
}
