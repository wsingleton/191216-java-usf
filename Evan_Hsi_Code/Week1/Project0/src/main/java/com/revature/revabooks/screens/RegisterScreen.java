package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistanceException;
import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;
import static com.revature.revabooks.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserService userv;

    public RegisterScreen(UserService userv) {
        super("RegisterScreen", "/register");
        this.userv = userv;
        System.out.println("[LOG] - Instantiating " + super.getName() + " with User Service.");
    }

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.println("Last name: ");
            lastName = console.readLine();
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            User newUser = new User(firstName, lastName, username, password);
            userv.register(newUser);

            if (currentUser != null) {
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                router.navigate("/dashboard");
            }

        } catch (InvalidRequestException | ResourcePersistanceException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }
}
