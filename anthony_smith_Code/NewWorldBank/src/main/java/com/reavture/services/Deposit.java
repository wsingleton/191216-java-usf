package com.reavture.services;

import com.reavture.pojo.*;
import com.reavture.repos.*;
import com.reavture.screens.*;

import java.util.Scanner;

public class Deposit {
    public static void deposit(int id) {

        int balance = 0;
        int deposit = 0;
        boolean valid = false;

        Account temp = null;

        Scanner scanner = new Scanner(System.in);


        BankRepo bankRepo = new BankRepo();
        temp = bankRepo.findAccountBank(id);
        balance = temp.getBalance();



        System.out.println("Please enter deposit amount: ");
        while (!valid) {
            try {
                String dummy = scanner.next();
                deposit = Integer.parseInt(dummy);

            } catch (Exception e) {
                System.out.println("Please enter a number: ");
            }
            System.out.println("Deposit in deposit = " + deposit);
            //Make sure withdrawal is not greater than the current balance
            if (deposit > 0) {
                balance += deposit;

                System.out.println("Balance = " + balance);

                Account updateUser = new Account(temp.getUser_id(), balance);


                bankRepo.updateAccountBank(updateUser);

                System.out.println("Your current balance is: " + updateUser.getBalance());

                valid = true;
            } else {

                System.out.println("Please deposit amount greater than 0.");


                System.out.println("Sorry. You made a invalid selection. Please try again");
                DashboardScreen.dashboard(id);
            }

            }


    }
}
