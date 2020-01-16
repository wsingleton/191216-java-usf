package com.bankboi.actions;

import com.bankboi.plainjava.BankAccounts;
import com.bankboi.repos.bankboirepo;
import com.bankboi.screens.AcctTrans;
import com.bankboi.screens.Existing;
import com.bankboi.screens.Out;

public class Balance {
    public static void viewBalance(int id){

        double balance = 0;
        BankAccounts temp = null;

        bankboirepo bankAccountRepo = new bankboirepo();

        temp = bankAccountRepo.findAccountBank(id);


        balance = temp.getBalance();

        BankAccounts updateUser = new BankAccounts(temp.getAccountOwner(), balance);
        bankAccountRepo.updateAccountBank(updateUser);
        System.out.println("You have $" + updateUser.getBalance());
        Out.signOut(id);




    }
}