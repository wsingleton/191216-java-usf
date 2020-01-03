package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;

import static com.revature.revabooks.AppDriver.*;

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
            System.out.println("Sign up for a new Account");
            System.out.print("First name: ");
            firstname = console.readLine();
            System.out.println("Last name: ");
            lastname = console.readLine();
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("password: ");
            password= console.readLine();

            User newUser = new User(firstname,lastname,username,password);
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
