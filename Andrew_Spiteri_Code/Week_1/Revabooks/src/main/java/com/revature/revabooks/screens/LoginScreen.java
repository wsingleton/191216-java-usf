package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.services.UserService;

import javax.security.sasl.AuthenticationException;

import static com.revature.revabooks.AppDriver.*;

public class LoginScreen extends Screen {
    private UserService userService;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating "+super.getName());
        this.userService =userService;
    }

    public void render() {

        String username, password;

       try{
           System.out.println("Please provide you creds: ");
           System.out.println("Username: ");
           username = console.readLine();
           System.out.println("Password: ");
           password = console.readLine();

           userService.authenticate(username,password);

           if(currentUser != null){
               router.navigate("/dashboard");
           }
       }catch (InvalidRequestException | AuthenticationException e){
           System.out.println("[LOG] - INVALID LOGIN CREDENTIALS PROVIDED!");
       }
       catch (Exception e){
           e.getMessage();
       }

    }
}
