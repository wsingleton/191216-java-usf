package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;

import com.revature.services.UserService;

import javax.security.sasl.AuthenticationException;

import static com.revature.AppDriver.*;
import static com.revature.util.AppState.console;
import static com.revature.util.AppState.router;


public class LoginScreen extends Screen {
    private UserService userService;

    public LoginScreen(UserService userService){

        super("LoginScreen", "/login");
        this.userService = userService;
    }

    @Override
    public void render(){
        String username;
        String password;

        try{
            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();

            userService.authenticate(username, password);

            if (app().isSessionValid()) {
                System.out.println("[LOG] - Login successful");
                router.navigate("/select");
            }
        } catch (InvalidRequestException | AuthenticationException e){
            System.out.println("[LOG] - invalid login credentials provided!");
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("[Error] - An unxpected exception occurred");
            System.out.println("[log] -goodybye");
            app().setAppRunning(false);
        }
    }
}