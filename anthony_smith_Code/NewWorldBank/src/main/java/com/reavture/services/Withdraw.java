package com.reavture.services;

import com.reavture.pojo.Account;
import com.reavture.repos.BankRepo;
import com.reavture.screens.DashboardScreen;

import java.util.Scanner;

public class  Withdraw {


    public static void withdraw(int id) {
        int balance = 0;
        int withdraw = 0;
        boolean valid = false;

        Account temp = null;

        Scanner scanner = new Scanner(System.in);

        BankRepo bankRepo = new BankRepo();

        temp = bankRepo.findAccountBank(id);

        balance = temp.getBalance();

        System.out.println("Please enter the amount you wish to withdraw amount: ");

        while (!valid) {
            try {
                 withdraw  = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }

            if (withdraw < balance + 1) {
                balance = balance - withdraw;
                Account updateUser = new Account(temp.getUser_id(), balance);

                bankRepo.updateAccountBank(updateUser);

                System.out.println("Your current balance is: " + updateUser.getBalance());

                valid = true;
            } else {
                System.out.println("Sorry Preforming a over draft is not allowed .");
                DashboardScreen.dashboard(id);
            }
        }
    }
}
