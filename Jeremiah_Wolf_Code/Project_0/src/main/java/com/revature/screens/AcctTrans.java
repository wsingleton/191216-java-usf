package com.revature.screens;

import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;

import java.util.Scanner;

public class AcctTrans {

    public static void accountTransaction(User user) {

        double balance;
        int option = 0;
        int ownerAccount = user.getId();

        Scanner scanner = new Scanner(System.in);


        User.Accounts_Bank account_Bank = new User.Accounts_Bank();


        account_Bank.setAccountOwner(ownerAccount);

        System.out.println("How many funds would you like? ");
        balance = scanner.nextDouble();

        account_Bank.setBalance(balance);



        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        bankAccountRepo.saveAccountBank(account_Bank);

        System.out.println("1. Make a transaction");
        System.out.println("2. Make a separate account, hero");
        System.out.println("3. Leave and fight crime!");


        do {
            System.out.println("What Would You like to do Hero?");

            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            }
            catch(Exception e){
                System.out.println("Enter Your Selection");
            }

            switch (option) {

                case 1:

                    Existing.existingUserScreen(user.getId());
                    break;
                case 2:
                    Create.createAccount();
                    break;
                case 3:
                    System.out.println("Good Morrow, Welcome to UA, PLUS ULTRA!");

                    break;

                default:

                    break;


            }

        } while(option != 3 );
        System.exit(0);
    }
}