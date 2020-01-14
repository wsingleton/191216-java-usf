package com.revature.bank.screens;

import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.User;
import com.revature.bank.services.UserService;

import java.io.IOException;

import static com.revature.bank.AppDriver.*;

public class RegisterScreen extends Screen{

    private UserService userService;

    public RegisterScreen(UserService userService){
        super("RegisterScreen", "/register");
        System.out.println("instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String userName;
        String passWord;

        try{
            System.out.println("\n\n\n\n\n\n\n\n");
            System.out.println("Register New Account");
            System.out.println("First Name:");
            firstName = console.readLine();
            System.out.println("Last Name:");
            lastName = console.readLine();
            System.out.println("Username:");
            userName = console.readLine();
            System.out.println("Password:");
            passWord = console.readLine();

            User newUser = new User(firstName, lastName, userName, passWord);
            userService.register(newUser);

            if(currentUser != null){
                System.out.println("New User Created! Logging in...");
                router.navigate("/profile");
            }
        }
        catch(InvalidRequestException e){
            e.printStackTrace();
        }
        catch (IOException e){
            System.err.println("An unexpected error occurred");
            System.err.println("Shutting down");
            appRunning = false;
        }
    }
}
