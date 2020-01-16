package com.revature.bankapp.screens;

import com.revature.bankapp.exceptions.AuthenticationException;
import com.revature.bankapp.services.UserService;
import static com.revature.bankapp.BankDriver.*;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen() {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName() + " with User Service.");
        this.userService = userService;
    }

    @Override
    public void render() {
        System.out.println("LoginScreen");

        String username = "";
        String password = "";

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();

            userService.authenticate(username, password);

            if(currentUser != null) {
                System.out.println("[LOG] - Login successful, navigating to dashboard...");
                router.navigate("/dashboard");
            }


        }
        catch(AuthenticationException e) {
            e.printStackTrace();
            System.out.println("[LOG] - Invalid login credentials provided");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            //System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }
}
