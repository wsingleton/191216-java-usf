package com.revature.service;

import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;
import com.revature.screens.Out;

import java.util.Scanner;

public class Withdraw {

    public static void withdraw(int id) {

        double balance = 0;
        double withdraw = 0;
        boolean valid = false;


        User.Accounts_Bank temp = null;

        Scanner scanner = new Scanner(System.in);

        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        temp = bankAccountRepo.findAccountBank(id);

        balance = temp.getBalance();

        System.out.println("How much would you like to withdraw hero? ");
        while(!valid) {
            try {
                String dummy = scanner.next();
                withdraw = Double.parseDouble(dummy);

            } catch(Exception e){
                System.out.println("Please enter a number: ");
            }

            if (withdraw < balance + 1 ) {

                balance -= withdraw;
                User.Accounts_Bank updateUser = new User.Accounts_Bank(temp.getAccountOwner(), balance);

                bankAccountRepo.updateAccountBank(updateUser);

                System.out.println("Your current balance is: $ " + updateUser.getBalance());

                valid = true;

            } else {

                System.out.println("Hero, you're broke you cannot overdraft");
                Out.signOut(id);

            }








        }
        Out.signOut(id);
    }

}