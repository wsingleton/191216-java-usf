package com.revature.screens;

import com.revature.BankMain;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.InvalidEntryException;
import com.revature.services.UserServices;
import sun.swing.BakedArrayList;

import java.io.IOException;

public class LoginScreen extends Screen {

    private UserServices uService;

    public LoginScreen(UserServices uService) {
        super("LoginScreen", "/login");
        this.uService = uService;
    }

    @Override
    public void load() {

        String username;
        String password;

        try {
            System.out.println("Enter your username:");
            username = BankMain.userInputs.readLine();
            System.out.println("Enter your password:");
            password = BankMain.userInputs.readLine();

            uService.login(username, password);

            } catch (InvalidEntryException | InvalidCredentialsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An unexpected event occurred");
            System.out.println("Exiting the application");
            BankMain.appLaunched = false;
        }

        System.out.println("login successful");

    }
}
