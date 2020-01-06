package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.services.UserService;

import java.util.Scanner;

import static com.revature.revabooks.AppDriver.*;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;
        try {
            System.out.println("\n\n\n\n\n\n\n\n\n\n+------------------------------------+");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.nextLine();
            System.out.print("Password: ");
            password = console.nextLine();

            userService.authenticate(username, password);

            if(currentUser != null){
                System.out.println("[LOG] - login successful navigating to dashboard.");
                router.navigate("/dashboard");
            }

        }catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided!");
        }
        catch (Exception E){
            System.err.println("[ERROR] - An unexpected error occured");
            System.err.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }
}
