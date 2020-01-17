package com.revature.service;

import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;
import com.revature.screens.Out;

import java.util.Scanner;

public class Deposit {
    public static void deposit(int id) {

        double balance;
        double deposit= 0;
        boolean valid = false;

        User.Accounts_Bank temp = null;

        Scanner scanner = new Scanner(System.in);


        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        temp = bankAccountRepo.findAccountBank(id);
        balance = temp.getBalance();

        System.out.println("How much would you like to deposit hero?");
        while(!valid) {
            try {
                String dummy = scanner.next();
                deposit = Double.parseDouble(dummy);

            } catch(Exception e){
                System.out.println("Please enter a number: ");
            }

            if (deposit > 0) {
                balance += deposit;

                User.Accounts_Bank updateUser = new User.Accounts_Bank(temp.getAccountOwner(), balance);

                bankAccountRepo.updateAccountBank(updateUser);

                System.out.println("Your current balance is: $ " + updateUser.getBalance());

                valid = true;
            } else {

                System.out.println("Please deposit amount greater than 0.");
                Out.signOut(id);



            }


        }
        Out.signOut(id);



    }
}
