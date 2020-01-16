package com.revature.screens;

import com.revature.pojos.Accounts_Bank;
import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;

import java.util.Scanner;

public class AccountTransactionScreen {

    public static void accountTransaction(User user) {

        double balance;
        int option = 0;
        int ownerAccount = user.getId();

        Scanner scanner = new Scanner(System.in);


        Accounts_Bank account_Bank = new Accounts_Bank();


        account_Bank.setAccountOwner(ownerAccount);

        System.out.println("Enter deposit amount: ");
        balance = scanner.nextDouble();

        account_Bank.setBalance(balance);



        BankAccountRepo bankAccountRepo = new BankAccountRepo();
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

                    ExistingUserScreen.existingUserScreen(user.getId());
                    break;
                case 2:
                    CreateAccountScreen.createAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using Kannon Bank.");

                    break;

                default:

                    break;


            }

        } while(option != 3 );
        System.exit(0);
    }
}
