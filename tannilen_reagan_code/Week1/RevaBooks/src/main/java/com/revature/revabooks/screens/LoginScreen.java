package com.revature.revabooks.screens;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.services.UserService;

public class LoginScreen extends Screen {
    private UserService userService;
    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + this.getName());
        this.userService=userService;
    }
    public void render() {
        String username;
        String password;
        try {
            System.out.println("\n");
            System.out.println("Please provide your login credentials.");
            System.out.println("Username:");
            System.out.print("> ");
            username=AppDriver.console.readLine();
            System.out.println("Password:");
            System.out.print("> ");
            password=AppDriver.console.readLine();
            userService.authenticate(username,password);
            if (AppDriver.currentUser!=null) {
                System.out.println("[LOG] - Login successful.  Proceeding to dashboard.");
                AppDriver.router.navigate("/dashboard");
            }

        }
        catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided.");
        }
        catch (Exception ex) {
            System.err.println("[ERROR] - An unexpected exception has occurred.");
            System.err.println("[LOG] - Exiting application.");
            AppDriver.appRunning=false;
        }
    }
}
