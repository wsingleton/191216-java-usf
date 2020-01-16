package com.bankboi.actions;

import com.bankboi.plainjava.BankAccounts;
import com.bankboi.repos.bankboirepo;
import com.bankboi.screens.Out;

import java.util.Scanner;

public class Withdraw {

    public static void withdraw(int id) {

        double balance = 0;
        double withdraw = 0;
        boolean valid = false;


        BankAccounts temp = null;

        Scanner scanner = new Scanner(System.in);


        bankboirepo bankAccountRepo = new bankboirepo();
        temp = bankAccountRepo.findAccountBank(id);

        balance = temp.getBalance();

        System.out.println("Enter Withdraw amount:");
        while(!valid) {
            try {
                String dummy = scanner.next();
                withdraw = Double.parseDouble(dummy);

            } catch(Exception e){
                System.out.println("Enter a number: ");
            }

            if (withdraw < balance + 1 ) {

                balance -= withdraw;
                BankAccounts updateUser = new BankAccounts(temp.getAccountOwner(), balance);



                bankAccountRepo.updateAccountBank(updateUser);

                System.out.println("You have:  " + updateUser.getBalance());

                valid = true;

            } else {

                System.out.println("No Overdrafts, enter amount less than what you have in your account: ");
                Out.signOut(id);

            }








        }
        Out.signOut(id);
    }

}
