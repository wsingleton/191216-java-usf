package com.revature.revabooks.screens;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistentException;
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
            System.out.println("\n\n\n\n\n\n\n\n\n\n+------------------------------------+");
            System.out.println("Sign up for new account");
            System.out.print("First name: ");
            firstName = console.nextLine();
            System.out.print("Last name: ");
            lastName = console.nextLine();
            System.out.print("Username: ");
            username = console.nextLine();
            System.out.print("Password : ");
            password = console.nextLine();

            User newUser = new User(firstName,lastName,username,password);
            userService.register(newUser);

            if (currentUser != null) {
                System.out.println("[LOG] - New user created! Navigating to dashboard...");
                router.navigate("/dashboard");
            }


        } catch (InvalidRequestException | ResourcePersistentException E){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        }
        catch (Exception e){
            System.err.println("[ERROR] - An unexpected error occurred");
            System.err.println("[LOG] - Shutting down application");
            AppDriver.appRunning = false;
        }

    }
}
