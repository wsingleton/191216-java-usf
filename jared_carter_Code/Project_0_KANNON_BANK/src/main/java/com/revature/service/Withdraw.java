package com.revature.service;

import com.revature.pojos.Accounts_Bank;
import com.revature.repo.BankAccountRepo;
import com.revature.screens.SignOutScreen;

import java.util.Scanner;

public class Withdraw {

    public static void withdraw(int id) {

        double balance = 0;
        double withdraw = 0;
        boolean valid = false;


        Accounts_Bank temp = null;

        Scanner scanner = new Scanner(System.in);


        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        temp = bankAccountRepo.findAccountBank(id);

        balance = temp.getBalance();

        System.out.println("Please enter withdraw amount: ");
        while(!valid) {
            try {
                String dummy = scanner.next();
                withdraw = Double.parseDouble(dummy);

            } catch(Exception e){
                System.out.println("Please enter a number: ");
            }

            if (withdraw < balance + 1 ) {

                balance -= withdraw;
                Accounts_Bank updateUser = new Accounts_Bank(temp.getAccountOwner(), balance);



                bankAccountRepo.updateAccountBank(updateUser);

                System.out.println("Your current balance is: " + updateUser.getBalance());

                valid = true;

            } else {

                System.out.println("Sorry, you do not enough to withdraw.");
                SignOutScreen.signOut(id);

               }








        }
        SignOutScreen.signOut(id);
    }

}
