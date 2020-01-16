package com.reavture.services;

import com.reavture.pojo.Account;
import com.reavture.repos.BankRepo;

public class ViewBalance {

    public static void viewBalance(int id){

        int balance =0;
        Account temp = null;

        BankRepo bankRepo = new BankRepo();

        temp = bankRepo.findAccountBank(id);

        balance = temp.getBalance();

        Account updateUser = new Account(temp.getAccountID(), balance);

        bankRepo.updateAccountBank(updateUser);

        System.out.println("Your current balance is $" + updateUser.getBalance());


    }
}
