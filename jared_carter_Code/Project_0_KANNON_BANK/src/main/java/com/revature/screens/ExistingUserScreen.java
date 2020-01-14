package com.revature.screens;

import com.revature.pojos.Accounts_Bank;
import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;
import com.revature.repo.UserRepo;
import com.revature.service.Deposit;

import java.util.Scanner;

public class ExistingUserScreen {

    public static void existingUserScreen(int id) {

        int option = 0;

        Scanner scanner = new Scanner(System.in);
        UserRepo userRepo = new UserRepo();
        User currentUser = userRepo.findUser(id);
        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        Accounts_Bank accounts_bank = bankAccountRepo.findAccountBank(currentUser.getId());

        System.out.println("Hello " + currentUser.getFirstName() + ".");
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. Sign out");

        do{
            System.out.println("Enter an option");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please select a number: ");
            }

            switch(option) {

                case 1:
                    Deposit deposit1 = new Deposit();
                   deposit1.deposit(id);
                    break;
                case 2:

                    withdraw(id);
                    break;
                case 3:
                    System.out.println("Thank you for using Kannon Bank.");
                    System.exit(0);;
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;

            }

        }while(option != 4);
    }
}
