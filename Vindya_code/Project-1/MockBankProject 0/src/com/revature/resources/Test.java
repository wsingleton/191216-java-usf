package com.revature.resources;

import com.revature.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("a");
        BankAccount a2 = new BankAccount("c");
        BankAccount a3 = new BankAccount("b");

        ArrayList<BankAccount> ListOfBankAccounts = new ArrayList<BankAccount>();

        ListOfBankAccounts.add(a1);
        ListOfBankAccounts.add(a2);
        ListOfBankAccounts.add(a3);

        for(BankAccount i: ListOfBankAccounts){
            System.out.println(i.getUsername());
        }
    }
}
