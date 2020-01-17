package com.bankboi.screens;

import com.bankboi.actions.Balance;
import com.bankboi.actions.Deposit;
import com.bankboi.actions.Withdraw;
import com.bankboi.plainjava.BankAccounts;
import com.bankboi.plainjava.Users;
import com.bankboi.repos.bankboirepo;
import com.bankboi.repos.userrepo;

import java.util.Scanner;

public class Existing {

    public static void existingUserScreen(int id) {

        int option = 0;

        Scanner scanner = new Scanner(System.in);
        userrepo userRepo = new userrepo();
        Users currentUser = userRepo.findUser(id);
        bankboirepo bankAccountRepo = new bankboirepo();
        BankAccounts accounts_bank = bankAccountRepo.findAccountBank(currentUser.getId());

        System.out.println("Hello " + currentUser.getFirstName());
        System.out.println("1. Make a deposit");
        System.out.println("2. Make a withdraw");
        System.out.println("3. View balance");
        System.out.println("4. Sign out");

        do{
            System.out.println("Enter an option");
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
                    System.out.println("Thank you for banking at BankBoi! Plus Ultra");

                    break;

                default:
                    break;

            }

        }while(option != 4);
        System.exit(0);
    }
}
