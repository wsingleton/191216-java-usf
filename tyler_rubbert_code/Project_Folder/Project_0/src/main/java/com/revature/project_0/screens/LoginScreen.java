package com.revature.project_0.screens;

import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.services.UserService;

import javax.security.sasl.AuthenticationException;

import static com.revature.project_0.AppDriver.*;

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

        try{

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Enter your username and password to login");
            System.out.println("Username: ");
            username = app().getConsole().readLine();
            System.out.println("Password: ");
            password = app().getConsole().readLine();

            userService.authenticate(username, password);

            if (app().isSessionValid()) {
                System.out.println("Login successful, navigating to user profile");
                app().getRouter().navigate("/user");
            }

        } catch (AuthenticationException e) {
            System.out.println("Invalid login credentials.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred");
            System.out.println("Shutting down application");
            app().setAppRunning(false);
        }

    }
}
