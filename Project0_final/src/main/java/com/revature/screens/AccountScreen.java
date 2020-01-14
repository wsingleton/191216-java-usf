package com.revature.screens;

import static com.revature.BankMain.userInputs;

public class AccountScreen extends Screen {

    public AccountScreen() {
        super("AccountScreen", "/account");
    }

    @Override
    public void load() {
        System.out.println("Your current balance is ");
        System.out.println("Press 1) to make a deposit or 2) to make a withdraw");

        try {

            String path = userInputs.readLine();
        }
    }
}
