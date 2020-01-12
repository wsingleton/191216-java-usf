package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;

import static com.revature.revabooks.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
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

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = app.getConsole().readLine();
            System.out.println("Last name: ");
            lastName = app.getConsole().readLine();
            System.out.println("Username: ");
            username = app.getConsole().readLine();
            System.out.println("Password: ");
            password = app.getConsole().readLine();

            User newUser = new User(firstName, lastName, username, password);
            userService.register(newUser);

            if (app.isSessionValid()) {
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                app.getRouter().navigate("/dashboard");
            }

        } catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            app.setAppRunning(false);
        }

    }

}
