package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;

import static com.revature.revabooks.AppDriver.*;

import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating "+super.getName());
        this.userService = userService;
    }

    public void render() {
        String fn, ln, un, pw;
        try {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n+------------------------------------------+");
            System.out.println("Sign up for a new account: ");
            System.out.println("First name: ");
            fn = console.readLine();
            System.out.println("Last name: ");
            ln = console.readLine();
            System.out.println("Userame: ");
            un = console.readLine();
            System.out.println("Password: ");
            pw = console.readLine();

            User newuser = new User(fn,ln,un,pw);
            userService.register(newuser);
            if (currentUser != null){
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                router.navigate("/dashboard");
            }
        }catch (InvalidRequestException | ResourcePersistenceException r){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken.");
        }catch (Exception e){
            System.err.println("[ERROR] - An unexpected exception occurred.");
            System.out.println();
            appRunning = false;
        }
    }
}
