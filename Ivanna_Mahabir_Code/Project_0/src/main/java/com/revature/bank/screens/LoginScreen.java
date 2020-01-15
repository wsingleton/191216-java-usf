package com.revature.bank.screens;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.services.UserService;

import static com.revature.bank.AppDriver.*;

public class LoginScreen extends Screen{

    private UserService userService;

    public LoginScreen(UserService userService){
        super("LoginScreen", "/login");
        System.out.println("[LOG] - instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;

        try{
            System.out.println("\n\n\n\n\n\n\n\n\n ------------------");
            System.out.println("Please provide your login credentials");
            System.out.println("Username: Must be between 8 to 15 characters in length \n" +
                    "\t\t  Must include at least 1 Capital letter \n" +
                    "\t\t  Must include at least 1 number\n");
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("\nPassword: Must be between 8 to 15 characters in length \n" +
                    "\t\t  Must include at least 1 Capital letter \n" +
                    "\t\t  Must include at least 1 number\n");
            System.out.println("Password: ");
            password = console.readLine();

            boolean userValid = currentUser.validate(username); //checks if username meets criteria
            boolean passValid = currentUser.validate(password); //checks if password meets criteria
            if(userValid!= true ||passValid != true){
                System.out.println("Invalid Input\n");
                router.navigate("/home");
            }

            userService.authenticate(username, password);

            System.out.println("Login successful\n\n");
            System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName());
            router.navigate("/profile");

        }
        catch(InvalidRequestException | AuthenticatironException e){
            e.printStackTrace();
            System.out.println("Invalid Login");
        }
        catch(Exception e){
            System.err.println("An unexpected error occurred. Program shutting down");
            appRunning = false;
        }
    }
}
