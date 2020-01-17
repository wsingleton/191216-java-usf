package com.revature.screens;

import com.revature.pojos.User;
import com.revature.repo.BankAccountRepo;
import com.revature.repo.UserRepo;
import com.revature.service.Deposit;
import com.revature.service.Balance;
import com.revature.service.Withdraw;

import java.util.Scanner;

public class Existing {

    public static void existingUserScreen(int id) {

        int option = 0;

        Scanner scanner = new Scanner(System.in);
        UserRepo userRepo = new UserRepo();
        User currentUser = userRepo.findUser(id);
        BankAccountRepo bankAccountRepo = new BankAccountRepo();
        User.Accounts_Bank accounts_bank = bankAccountRepo.findAccountBank(currentUser.getId());

        System.out.println("Welcome " + currentUser.getFirstName());
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdraw");
        System.out.println("3. View your current funds");
        System.out.println("4. Go fight Evil");

        do{
            System.out.println("What is your choice hero?");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1, 2, 3 or 4");
            }

            switch(option) {

                case 1:

                    Deposit.deposit(id);
                    break;
                case 2:

                    Withdraw.withdraw(id);
                    break;

                case 3:
                    Balance.viewBalance(id);
                    break;

                case 4:
                    System.out.println("Go and Save the WORLD ");

                    break;

                default:
                    break;

            }

        }while(option != 4);
        System.exit(0);
    }
}