package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.services.UserService;

import javax.security.sasl.AuthenticationException;

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

            System.out.println("\n\n\n\n\n\n\n\n\n+------------------+\n");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();

            userService.authenticate(username, password);

            if (currentUser != null) {
                System.out.println("[LOG - Login successful, navigating to dashboard...");
                router.navigate("/dashboard");
            }


        }catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided!");
        }
        catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }

}
