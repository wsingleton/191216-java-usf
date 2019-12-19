package com.bank.ui;

import java.util.Scanner;
import com.bank.models.Account;

public class DepositScreen {

    public void deposit() {

        Account acct = new Account();
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
