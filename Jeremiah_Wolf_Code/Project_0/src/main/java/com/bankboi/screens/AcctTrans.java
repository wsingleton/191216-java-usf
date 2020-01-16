package com.bankboi.screens;

import com.bankboi.plainjava.BankAccounts;
import com.bankboi.plainjava.Users;
import com.bankboi.repos.bankboirepo;

import java.util.Scanner;

public class AcctTrans {

    public static void accountTransaction(Users user) {

        double balance;
        int option = 0;
        int ownerAccount = user.getId();

        Scanner scanner = new Scanner(System.in);


        BankAccounts account_Bank = new BankAccounts();


        account_Bank.setAccountOwner(ownerAccount);

        System.out.println("Enter deposit amount: ");
        balance = scanner.nextDouble();

        account_Bank.setBalance(balance);



        bankboirepo bankAccountRepo = new bankboirepo();
        bankAccountRepo.saveAccountBank(account_Bank);

        System.out.println("1. Make a transaction");
        System.out.println("2. Create another account");
        System.out.println("3. Sign out");


        do {
            System.out.println("Enter an option");

            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            }
            catch(Exception e){
                System.out.println("Please enter 1, 2 or 3 ");
            }

            switch (option) {

                case 1:

                    Existing.existingUserScreen(user.getId());
                    break;
                case 2:
                    Create.createAccount();
                    break;
                case 3:
                    System.out.println("Thanks for banking at BankBoi. PLUS ULTRA!");

                    break;

                default:

                    break;


            }

        } while(option != 3 );
        System.exit(0);
    }
}