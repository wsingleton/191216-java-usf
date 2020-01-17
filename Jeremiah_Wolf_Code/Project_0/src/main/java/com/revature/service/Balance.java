
package com.revature.service;

import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;
import com.revature.screens.Out;

public class Balance {
    public static void viewBalance(int id){

        double balance = 0;
        User.Accounts_Bank temp = null;

        BankAccountRepo bankAccountRepo = new BankAccountRepo();

        temp = bankAccountRepo.findAccountBank(id);


        balance = temp.getBalance();

        User.Accounts_Bank updateUser = new User.Accounts_Bank(temp.getAccountOwner(), balance);
        bankAccountRepo.updateAccountBank(updateUser);
        System.out.println("Your current balance is $" + updateUser.getBalance());
        Out.signOut(id);




    }
}