package com.revature.service;

import com.revature.pojos.Accounts_Bank;

import java.util.Scanner;

public class Deposit {
    public static void deposit(int id) {

        double balance = 0;
        double deposit= 0;
        boolean valid = false;

        Accounts_Bank temp = null;

        Scanner scanner = new Scanner(System.in);

        //find account associated with id
        temp = bankAccountRepo.findAccountBank(id);

        balance = temp.getBalance();

        System.out.println("Please enter deposit amount: ");
        while(!valid) {
            try {
                String dummy = scanner.next();
                deposit = Double.parseDouble(dummy);

            } catch(Exception e){
                System.out.println("Please enter a number: ");
            }
            //Make sure withdrawal is not greater than the current balance
            if (deposit > 0) {
                balance += deposit;

                Accounts_Bank updateUser = new Accounts_Bank(temp.getAccountOwner(), balance);

                bankAccountRepo.updateAccountBank(updateUser);

                System.out.println("Your current balance is: " + updateUser.getBalance());

                valid = true;
            } else {

                System.out.println("Please deposit amount greater than 0.");
                SignOut(id);


            }


        }
        SignOut(id);



    }
}
