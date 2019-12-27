package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bank.dao.AccountDao.replaceBalance;

public class WithdrawScreen extends User {

    public static void withdraw(Account acct) {


        double bal = acct.getBalance();
        double newBalance = 0;
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

        if(amount > bal || amount < 0) {

            System.out.println("Sorry, no overdrafts allowed.");
            System.out.println("Please try again");
            withdraw(acct);
        }
        else {

            newBalance = bal - amount;
            acct.setBalance(newBalance);
            int oldAcct =  acct.getiD();
            String oldAcctBal = Double.toString(bal);
            String oldAcctNum = Integer.toString(oldAcct);
            String newAcctNum = Integer.toString(oldAcct);
            String newAcctBal = Double.toString(newBalance);
            replaceBalance(oldAcctNum, oldAcctBal, newAcctNum, newAcctBal);

        }

        System.out.println("Your new balance is $" + newBalance);
        System.out.println("Would you like to perform another transaction?");
        System.out.print("1 = Yes, 0 = No: ");

        DepositScreen.newTransaction(acct, input);
    }
}
