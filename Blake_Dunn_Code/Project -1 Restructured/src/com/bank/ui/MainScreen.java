package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainScreen extends User {

    public static void homeScreen() {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Faux Bank");
        System.out.println("To sign in, press 0");
        System.out.println("To create an account, press 1:  ");
        int number = input.nextInt();

        if (number == 0){
            LoginScreen.login();
        }
        else if (number == 1){
            RegisterScreen.register();
        }
        else{
            System.out.println("Error: Please press 0 or 1");
            homeScreen();
        }
    }

    public static void display(Account acct) {

        try{
            Scanner input = new Scanner(System.in);

            System.out.println("Check Balance = 0");
            System.out.println("Deposit = 1");
            System.out.println("Withdraw = 2");
            System.out.print("Please choose an option: ");
            int number = input.nextInt();

            if (number == 0){
                BalanceScreen.checkBalance(acct);
            }
            else if(number == 1){
                DepositScreen.deposit(acct);
            }
            else if(number == 2){
                WithdrawScreen.withdraw(acct);
            }
            else{
                System.out.println("Error: Please try again");
                System.out.println("");
                display(acct);
            }
        }catch(InputMismatchException ime){
            display(acct);
        }
    }
}
