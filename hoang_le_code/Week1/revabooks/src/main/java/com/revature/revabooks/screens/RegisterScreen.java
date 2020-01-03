package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;

import static com.revature.revabooks.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());

        this.userService = userService;

    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;




        try{

            System.out.println("\n\n\n\n\n\n\n\n\n+-----------------------+\n");
            System.out.println("Signup for new account");
            System.out.println("firstname : ");
            firstName = console.readLine();
            System.out.println("last name :");
            lastName = console.readLine();
            System.out.println("User name :");
            username = console.readLine();
            System.out.println("password");
            password = console.readLine();

            User newUser = new User(firstName,lastName,username,password);
            userService.register(newUser);

            if(currentUser != null){
                System.out.println("[log] - new user created! navigateing to dashboard...'");
                router.navigate("/dashboard");
            }



        }catch (InvalidRequestException | ResourcePersistenceException e){
            System.out.println("Registration fail, invalid values provide");

        }catch (Exception e){
            System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }

}