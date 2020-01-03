package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bank.dao.AccountDao.replaceBalance;
import static com.bank.service.AccountService.validateAmount;
import static com.bank.service.UserService.newTransaction;
import static com.bank.ui.MainScreen.display;

public class DepositScreen extends User {

    public static void deposit(Account acct) {

        double bal = acct.getBalance();
        double newBalance = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("Your Account Balance: $" + bal);
        System.out.print("Enter the deposit amount (Must be less than 10000: ");
        double amount = 0;
        try {
            amount = input.nextDouble();

            if(amount < 0 || amount > 10000){
                System.out.println("Try again!!");
                display(acct);
            }else {
                amount = validateAmount(amount);
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
            System.out.println("Try again.");
            deposit(acct);
        }
        System.out.println("Your new balance is $" + newBalance);
        System.out.println("Would you like to perform another transaction?");
        System.out.print("0 = Exit, 1 = Yes, 2 = Logout: ");
        newTransaction(acct, input);
    }


}
