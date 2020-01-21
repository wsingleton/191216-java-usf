package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.services.UserService;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

import static com.revature.AppDriver.*;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService){
        super("logInScreen", "/login");


        this.userService = userService;
    }


    @Override
    public void render() throws IOException {


        String username;
        String password;


        try {


            System.out.println("Please Enter Your Credentials...");
            System.out.println("Username: ");
            username = app().getConsole().readLine();
            System.out.println("Password: ");
            password = app().getConsole().readLine();

            userService.authenticate(username, password);

            if (app().getCurrentSession().getSessionUser() !=null){
                System.out.println("login successful");
                app().getRouter().navigate("/dashboard");
            }

        } catch (InvalidRequestException | AuthenticationException e){
            System.out.println("Invalid");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("unexpected error");
            System.out.println("shutting down");
            app().setAppRunning(false);
        }
    }
}
