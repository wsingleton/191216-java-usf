package com.bank.ui;

import com.bank.models.Account;
import java.util.Scanner;

public class BalanceScreen {

    public static void checkBalance(Account acct){

        Scanner scanner = new Scanner(System.in);
        double bal = acct.getBalance();

        System.out.println("");
        System.out.println("Your Balance: $" + bal);

        System.out.println("Would you like to perform another transaction?");
        System.out.print("1 = Yes, 0 = No: ");
        DepositScreen.newTransaction(acct, scanner);
    }
}
