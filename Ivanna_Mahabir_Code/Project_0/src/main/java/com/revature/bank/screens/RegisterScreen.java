package com.revature.bank.screens;

import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.exceptions.ResourcePersistenceException;
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
            System.out.println("Register New Account\n");
            System.out.println("Username: Must be between 8 to 15 characters in length \n" +
                    "\t\t  Must include at least 1 Capital letter \n" +
                    "\t\t  Must include at least 1 number\n");
            System.out.println("Username:");
            userName = console.readLine();
            System.out.println("Password: Must be between 8 to 15 characters in length \n" +
                    "\t\t  Must include at least 1 Capital letter \n" +
                    "\t\t  Must include at least 1 number\n");
            System.out.println("Password:");
            passWord = console.readLine();

            boolean userValid = currentUser.validate(userName); //checks if username meets criteria
            boolean passValid = currentUser.validate(passWord); //checks if password meets criteria
            if(userValid != true ||passValid != true){
                System.out.println("Invalid Input\n");
                router.navigate("/home");
            }

            System.out.println("First Name:");
            firstName = console.readLine();
            System.out.println("Last Name:");
            lastName = console.readLine();

            User newUser = new User(firstName, lastName, userName, passWord);

            userService.register(newUser);

            if(currentUser != null){
                System.out.println("New User Created! Logging in...");
                router.navigate("/profile");
            }
        }
        catch(InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
            e.printStackTrace();
        }
        catch (IOException e){
            System.err.println("An unexpected error occurred");
            System.err.println("Shutting down");
            appRunning = false;
        }
    }
}
