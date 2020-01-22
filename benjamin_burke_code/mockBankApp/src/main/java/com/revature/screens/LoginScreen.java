package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.services.UserService;

import javax.security.sasl.AuthenticationException;

import static com.revature.AppDriver.*;


public class LoginScreen extends Screen {
    private UserService userService;

    public LoginScreen(UserService userService){

        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating" + super.getName());
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
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();

            userService.authenticate(username, password);

            if (currentUser !=null) {
                System.out.println("[LOG] - Login successful");
                router.navigate("/select");
            }
        } catch (AuthenticationException e){
            System.out.println("[LOG] - invalid login credentials provided!");
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("[Error] - An unexpected exception occurred");
            System.out.println("[log] -goodybye");
            appRunning=false;
        }
    }
}
