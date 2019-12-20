package com.bank.ui;

import com.bank.models.User;
import com.bank.models.Account;

import java.util.Scanner;

public class LoginScreen {

    public void login() {

        for (int i = 0; i < 2; i++) {
            Scanner scanner = new Scanner(System.in);
            String[] registerArray = new String[]{"user name", "password"};
            System.out.println("Please enter your " + registerArray[i] + ":");
            String login = scanner.next();
        }
    }
}
