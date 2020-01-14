package com.revature.bank2.screens;


import com.revature.bank2.util.UserService;

import java.util.Scanner;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService){
        super("Login", "/login");
        System.out.println("[LOG] - Instanting" + super.getName());
        this.userService = userService;
    }

    @Override
    public void render(){

        String username;
        String password;

        try {
            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Please enter in your username:");
            username = app.getConsole().readLine();
            System.out.println("Please enter in your password: ");
            password = app.getConsole().readLine();

            userService.authenticate(username, password);

            if (app.isSessionValid()) {
                System.out.println("[LOG] - Login successful, navigating to dashboard...");
                app.getRouter().navigate("/dashboard");
            }

        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided!");
        } catch (Exception e) {
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            app.setAppRunning(false);
        }
    }

}

