package com.revature.screens;

import com.revature.BankMain;
import com.revature.exceptions.DuplicateException;
import com.revature.exceptions.InvalidEntryException;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.UserRepository;
import com.revature.services.UserServices;

import java.io.IOException;

public class RegisterScreen extends Screen {

    private UserServices uServices;

    public RegisterScreen(UserServices uServices) {
        super("RegisterScreen", "/register");
        this.uServices = uServices;
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
            uServices.register(newUser);
            System.out.println("Registration successful! Directing to home page");
            BankMain.navigation.navigate("/home");

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
