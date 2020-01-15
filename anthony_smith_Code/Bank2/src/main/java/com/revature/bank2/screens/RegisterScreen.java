package com.revature.bank2.screens;

import com.revature.bank2.exceptions.InvalidRequestException;

import java.util.Scanner;

public class RegisterScreen extends Screen{

    private UserService userService;

    public RegisterScreen(UserService){
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;
        double accountBalance;
        try {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Please enter in your first name ");
            firstName = app().getConsole().readLine();

            System.out.println("Please enter in your last name");
            lastName = app().getConsole().readLine();

            System.out.println("Please enter in a User Name");
            username = app().getConsole().readeLine();

            System.out.println("Please enter in a password");
            password = app().getConsole().readLine();

            System.out.println("You must enter a initial Deposit. Please enter the amount you wish to deposit");
             accountBalance = app().getConsole.readline

            User newUser = new User(firstName, lastName, username, password);
            userService.register(newUser);

            if (app().isSessionValid()) {
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                app().getRouter().navigate("/dashboard");
            }
        } catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            app().setAppRunning(false);
        }


    }
    }
}
