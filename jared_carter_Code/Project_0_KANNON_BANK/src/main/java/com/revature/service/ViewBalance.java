package com.revature.service;

import com.revature.pojos.Accounts_Bank;
import com.revature.repo.BankAccountRepo;

public class ViewBalance {
    public static void viewBalance(int id){

        double balance = 0;
        Accounts_Bank temp = null;

        BankAccountRepo bankAccountRepo = new BankAccountRepo();

        temp = bankAccountRepo.findAccountBank(id);

        balance = temp.getBalance();

        Accounts_Bank updateUser = new Accounts_Bank(temp.getAccountOwner(), balance);
        bankAccountRepo.updateAccountBank(updateUser);
        System.out.println("Your current balance is $" + updateUser.getBalance());




    }
}
