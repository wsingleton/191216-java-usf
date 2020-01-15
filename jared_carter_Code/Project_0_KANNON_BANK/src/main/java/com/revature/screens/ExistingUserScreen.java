package com.revature.screens;

import com.revature.pojos.Accounts_Bank;
import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;
import com.revature.repo.UserRepo;
import com.revature.service.Deposit;
import com.revature.service.ViewBalance;
import com.revature.service.Withdraw;

import java.util.Scanner;

public class ExistingUserScreen {

    public static void existingUserScreen(int id) {

        int option = 0;

        Scanner scanner = new Scanner(System.in);
        UserRepo userRepo = new UserRepo();
        User currentUser = userRepo.findUser(id);
        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        Accounts_Bank accounts_bank = bankAccountRepo.findAccountBank(currentUser.getId());

        System.out.println("Hello " + currentUser.getFirstName());
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdrawal");
        System.out.println("3. View balance");
        System.out.println("4. Sign out");

        do{
            System.out.println("Enter an option");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1, 2 or 3");
            }

            switch(option) {

                case 1:

                   Deposit.deposit(id);
                    break;
                case 2:

                    Withdraw.withdraw(id);
                    break;

                case 3:
                    ViewBalance.viewBalance(id);
                    break;

                case 4:
                    System.out.println("Thank you for using Kannon Bank.");

                    break;

                default:
                   // System.out.println("Please enter 1, 2 or 3");
                    break;

            }

        }while(option != 4);
        System.exit(0);
    }
}
