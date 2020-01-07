package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.User;
import com.liberationbank.services.UserService;

import static com.liberationbank.AppDriver.*;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userService){
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating "+ super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String firstname;
        String lastname;
        String username;
        String password;
        try {
            System.out.println("\n\n\n\n\n\n\n\n\n+-------------------------------+\n");
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstname = console.readLine();
            System.out.print("Last name: ");
            lastname = console.readLine();
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("password: ");
            password= console.readLine();

            User newUser = new User(firstname,lastname,username,password);
            //System.out.println(newUser);
            userService.register(newUser);
            if(currentUser != null){
                System.out.println("[LOG] - New user created! navigating to dashboard...");
                System.out.println(newUser);
                router.navigate("/dashboard");
            }

        }catch(InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        }catch(Exception e){
            System.err.println("[ERROR] - An Unexpected exception occured");
            System.out.println("[LOG] - shutting down application");
            appRunning = false;
        }
    }

}
