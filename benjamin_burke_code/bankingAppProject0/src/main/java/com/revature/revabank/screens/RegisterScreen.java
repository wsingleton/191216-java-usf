package com.revature.revabank.screens;

import com.revature.revabank.AppDriver;
import com.revature.revabank.exceptions.InvalidRequestException;
import com.revature.revabank.exceptions.ResourcePersistenceException;
import com.revature.revabank.models.User;
import com.revature.revabank.services.UserService;

import static com.revature.revabank.AppDriver.*;


public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService){
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.userService = userService;
    }

    @Override
    public void render(){
        String firstName;
        String lastName;
        String username;
        String password;

        try {
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.println("Last name:");
            lastName = console.readLine();
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            User newUser = new User(firstName, lastName, username, password);
            userService.register(newUser);
         if (currentUser !=null){
            System.out.println("[LOG] - New User created! Navigating to dashboard...");
            router.navigate("/dashboard");
        }


    } catch (InvalidRequestException | ResourcePersistenceException e){
       System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e){
            System.out.println("[Error]");
            System.out.println("[LOG] - Shutting down");
            appRunning = false;
        }
    }
}
