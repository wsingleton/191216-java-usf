package com.banking.screens;

import com.banking.pojos.Accounts_Bank;
import com.banking.pojos.User;

import java.util.Scanner;

public class AccountTransaction {
    public static void accountTransaction(User user) {

        Double balance;
        int option = 0;
        int ownerAccount = user.getId();

        Scanner scanner = new Scanner(System.in);


        Accounts_Bank account_Bank = new Accounts_Bank();


        account_Bank.setAccountOwner(ownerAccount);

        System.out.println("Enter deposit amount: ");
        balance = scanner.nextDouble();

        account_Bank.setBalance(balance);

        //add bank account info to Bank

        bankAccountRepo.saveAccountBank(account_Bank);

        System.out.println("1. Make a transaction");
        System.out.println("2. Create another account");
        System.out.println("3. Sign out");

        System.out.println("Enter an option");
        do {
            option = scanner.nextInt();

            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            }
            catch(Exception e){
                System.out.println("Please select a number: ");
            }

            switch (option) {

                case 1:
                    ExistingUserScreen(user.getId());
                    break;
                case 2:
                    accountTransaction(user);
                    break;
                case 3:
                    System.out.println("Thank you for using Kannon Bank.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option.");
                    accountTransaction(user);
                    break;


            }

        }while(option !=4);
    }
}
