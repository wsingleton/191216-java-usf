package com.revature.screens;

import java.io.IOException;

import static com.revature.BankMain.appLaunched;
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

            switch (path) {
                case "1" :
                    //deposit method here
                    break;
                case "2" :
                    //withdraw method here
                    break;
                default:
                    //throw an exception here
            }
        } catch (IOException e ) {
            System.err.println("An unexpected problem occurred...proceeding to shutdown");
            appLaunched = false;
        }
    }
}
