package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.services.UserService;
import static com.revature.revabooks.AppDriver.*;

public class LoginScreen extends Screen {

    private UserService userv;

    public LoginScreen(UserService userv) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName() + " with User Service.");
        this.userv = userv;
    }

    public LoginScreen() {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public void render() {
        System.out.println("LoginScreen");

        String username;
        String password;
        //userv.printUsers();
        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Please provide your login credentials");
            System.out.println("Username: ");
            username = consoLe.readLine();
            System.out.println("Password: ");
            password = consoLe.readLine();
            System.out.println("preKappa");

            userv.authenticate(username, password);

            System.out.println("kappa");

            if (currentUser != null) {
                System.out.println("[LOG] - Login successful, navigating to dashboard...");
                router.navigate("/dashboard");
            }

        }
        catch(InvalidRequestException | AuthenticationException e) {
            e.printStackTrace();
            System.out.println("[LOG] - Invalid login credentials provided!");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }
}
