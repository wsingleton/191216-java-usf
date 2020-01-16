package com.revature.screens;

import com.revature.BankMain;
import com.revature.exceptions.DuplicateException;
import com.revature.exceptions.InvalidEntryException;
import com.revature.models.User;
import com.revature.services.UserServices;

import java.io.IOException;

public class RegisterScreen extends Screen {

    private UserServices uService;

    public RegisterScreen(UserServices uService) {
        super("RegisterScreen", "/register");
        this.uService = uService;
    }

    @Override
    public void load() {

        String username;
        String password;

        try {

            System.out.println("Enter your username desired username ");
            username = BankMain.userInputs.readLine();
            System.out.println("Enter your password desired password ");
            password = BankMain.userInputs.readLine();

            User newUser = new User (username, password, 0.0);
            uService.register(newUser);
            System.out.println("Registration successful! Directing to account page");
            BankMain.navigation.navigate("/account");



        } catch (InvalidEntryException | DuplicateException e) {
            System.err.println("Registration failed");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An unexpected event occurred");
            System.out.println("Exiting the application");
            BankMain.appLaunched = false;
        }
    }
}
