package com.bank.ui;

import com.bank.models.Account;
import java.util.Scanner;

public class WithdrawScreen {

    public void withdraw() {

        Account acct = new Account();
        double bal = acct.getBalance();
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.print("Enter the withdrawal amount: ");
        double amount = input.nextDouble();

        bal -= amount;
        acct.setBalance(bal);
    }
}
