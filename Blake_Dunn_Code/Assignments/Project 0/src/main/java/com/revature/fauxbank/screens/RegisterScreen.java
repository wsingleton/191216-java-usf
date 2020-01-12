package com.revature.fauxbank.screens;

import com.revature.fauxbank.exceptions.InvalidRequestException;
import com.revature.fauxbank.exceptions.ResourcePersistenceException;
import com.revature.fauxbank.models.User;
import com.revature.fauxbank.services.UserService;

import static com.revature.fauxbank.BankDriver.*;

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
