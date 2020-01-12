package com.revature.screens;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.services.UserService;

import static com.revature.BankDriver.*;

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
            System.out.println("\n\n\n\n\n\n\n\n\n\n+------------------------------------+");
            System.out.println("Please provide your username and password.");
            System.out.print("Username: ");
            username = console.nextLine();
            System.out.print("Password: ");
            password = console.nextLine();

            userService.authenticate(username.toLowerCase(), password);

            if(currentUser != null){
                router.navigate("/customer");
            }

        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("-------------------------------");
            System.out.println("Invalid Credentials");
            System.out.println("-------------------------------\n\n");
        }
        catch (Exception E){
            appRunning = false;
        }
    }
}
