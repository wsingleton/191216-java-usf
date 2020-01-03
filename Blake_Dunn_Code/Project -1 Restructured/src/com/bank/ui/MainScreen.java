package com.bank.ui;

import com.bank.models.Account;
import com.bank.models.User;

import static com.bank.service.UserService.validateHomeScreenInput;
import static com.bank.service.UserService.validateUserInput;
import static com.bank.ui.BalanceScreen.checkBalance;
import static com.bank.ui.DepositScreen.deposit;
import static com.bank.ui.LoginScreen.login;
import static com.bank.ui.RegisterScreen.register;
import static com.bank.ui.WithdrawScreen.withdraw;


public class MainScreen extends User {

    public static int homeScreen() {

        System.out.println("Welcome to Faux Bank");
        int number = validateHomeScreenInput();

        return number;
    }

    public static void display(Account acct) {

            int number = validateUserInput(acct);

            if (number == 0){
                checkBalance(acct);
            }
            else if(number == 1){
                deposit(acct);
            }
            else{
                withdraw(acct);
            }
    }
}
