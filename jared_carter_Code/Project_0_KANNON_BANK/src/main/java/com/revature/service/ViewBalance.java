package com.revature.service;

import com.revature.pojos.Accounts_Bank;

public class ViewBalance {
    public static void viewBalance(int id){

        Accounts_Bank accounts_bank = new Accounts_Bank();
        System.out.println("Your current balance is $" + accounts_bank.getBalance());



    }
}
