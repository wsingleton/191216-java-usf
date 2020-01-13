package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.exceptions.AuthenticationException;
import com.revature.fauxbankextended.exceptions.InvalidRequestException;
import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.*;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        this.userService = userService;
    }

    @Override
    public void render() {

        String username;
        String password;

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            userService.authenticate(username, password);

            if (app().isSessionValid()) {
                System.out.println("[LOG - Login successful, navigating to dashboard...");
                app().getRouter().navigate("/dashboard");
            }

        }catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided!");
        }
        catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            app().setAppRunning(false);
        }

    }
}