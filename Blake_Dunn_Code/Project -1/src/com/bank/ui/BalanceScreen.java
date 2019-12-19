package com.bank.ui;

import com.bank.models.Account;

public class BalanceScreen {

    public void checkBalance(){

        Account acct = new Account();
        double bal = acct.getBalance();

        System.out.println("");
        System.out.println("Your Balance: $" + bal);

    }
}
