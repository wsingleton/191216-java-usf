package com.bank.ui;

import java.util.Scanner;

import com.bank.models.User;
import com.bank.service.UserService;

public class RegisterScreen {

    public void register() {

        for(int i = 0; i < 4; i++) {
        Scanner scanner = new Scanner(System.in);
        String[] registerArray = new String[]{"first name", "last name", "user name", "password"};
            System.out.println("Please enter your " + registerArray[i] + ":");
            String input = scanner.next();

            String[] storeInput = new String[];

            User newUser = new User();
        }


    }
}
