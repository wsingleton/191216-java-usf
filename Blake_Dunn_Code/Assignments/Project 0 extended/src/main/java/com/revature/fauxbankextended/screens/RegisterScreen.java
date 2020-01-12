package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.exceptions.InvalidRequestException;
import com.revature.fauxbankextended.exceptions.ResourcePersistenceException;
import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.*;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        this.userService = userService;
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String userName;
        String password;
        String type;

        try{

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Sign up for a new account");
            System.out.print("First name: " );
            firstName = console.readLine();
            System.out.print("Last name: ");
            lastName = console.readLine();
            System.out.print("Username (Must be between 8-14 characters): ");
            userName = console.readLine();
            System.out.println("Password must contain special character and be between 8-14 characters.");
            System.out.print("Password: ");
            password = console.readLine();

            User newUser = new User(firstName, lastName, userName, password);
            userService.register(newUser);

            System.out.println("Please choose an account type.");
            System.out.println("1) Checking Account");
            System.out.println("2) Savings Account");
            System.out.print("> ");
            type = console.readLine();
            userService.setNewAccount(type);

            if (currentUser != null && currentAccount != null) {
                router.navigate("/dashboard");
            }

        }catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        }catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
