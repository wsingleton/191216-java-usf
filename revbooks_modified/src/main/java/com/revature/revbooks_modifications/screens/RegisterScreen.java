package com.revature.revbooks.screens;

import com.revature.revbooks.exceptions.InvalidRequestException;
import com.revature.revbooks.exceptions.ResourcePersistenceException;
import com.revature.revbooks.models.User;
import com.revature.revbooks.services.UserService;

import static com.revature.revbooks.AppDriver.*;

public class RegisterScreen extends Screen {

    private  UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG}] - Instantiating " + super.getName());
        this.userService = userService;

    }

    @Override
    public void render() {

        String firstName;
        String lastName;
        String username;
        String password;

        try {

            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.print("Last name: ");
            lastName = console.readLine();
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();

            User newUser = new User(firstName, lastName, username, password);
            userService.register(newUser);

            if (currentUser != null) {
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                router.navigate("/dashboard");
            }

        } catch (InvalidRequestException | ResourcePersistenceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }
}
