package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bank.service.UserService.validateHomeScreenInput;
import static com.bank.service.UserService.validateUserInput;

public class MainScreen extends User {

    public static void homeScreen() {

        System.out.println("Welcome to Faux Bank");
        int number = validateHomeScreenInput();

        if (number == 0){
            LoginScreen.login();
        }
        else
            RegisterScreen.register();

    }

    public static void display(Account acct) {

            int number = validateUserInput(acct);

            if (number == 0){
                BalanceScreen.checkBalance(acct);
            }
            else if(number == 1){
                DepositScreen.deposit(acct);
            }
            else{
                WithdrawScreen.withdraw(acct);
            }
    }
}
