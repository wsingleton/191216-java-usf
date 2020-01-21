package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.User;

import com.revature.revabooks.services.UserService;

import static com.revature.revabooks.AppDriver.*;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userServices){
        super("RegisterScreen","/register");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.userService = userServices;
    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;

        try {
//        System.out.println("\n\n\n|n\n\n\n\n\n+-------------------------------");
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.println("Last name:");
            lastName = console.readLine();
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            User newUser = new User(firstName, lastName, username, password);
            userService.register(newUser);

            if (currentUser !=null){
                System.out.println("[LOG]- New user created! Navigating to dashboard...");
                router.navigate("/dashboard");
            }


        } catch (InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken.");
        } catch (Exception e){
            System.out.println("[Error]");
            System.out.println("[LOG] - Shutting down ");
            appRunning = false;
        }
    }
}