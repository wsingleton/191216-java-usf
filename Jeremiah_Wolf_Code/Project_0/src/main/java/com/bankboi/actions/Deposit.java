package com.bankboi.actions;


import com.bankboi.plainjava.BankAccounts;
import com.bankboi.repos.bankboirepo;
import com.bankboi.screens.AcctTrans;
import com.bankboi.screens.Out;

import java.util.Scanner;

public class Deposit {
    public static void deposit(int id) {

        double balance;
        double deposit= 0;
        boolean valid = false;

        BankAccounts temp = null;

        Scanner scanner = new Scanner(System.in);


        bankboirepo bankAccountRepo = new bankboirepo();
        temp = bankAccountRepo.findAccountBank(id);
        balance = temp.getBalance();

        System.out.println("How much do you want to put into you acct: ");
        while(!valid) {
            try {
                String dummy = scanner.next();
                deposit = Double.parseDouble(dummy);

            } catch(Exception e){
                System.out.println("Put in a number: ");
            }

            if (deposit > 0) {
                balance += deposit;

                BankAccounts updateUser = new BankAccounts(temp.getAccountOwner(), balance);

                bankAccountRepo.updateAccountBank(updateUser);

                System.out.println("you have:  " + updateUser.getBalance());

                valid = true;
            } else {

                System.out.println("Deposit more than $0 ");
                Out.signOut(id);



            }


        }
        Out.signOut(id);



    }
}
