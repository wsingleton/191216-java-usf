package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.User;

import com.revature.services.AccountService;

import com.revature.services.UserService;

import static com.revature.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserService userService;
    private AccountService accountService;

    public RegisterScreen(UserService userService, AccountService accountService ) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
        this.accountService = accountService;

    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;


        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Sign up for a new account");
            System.out.print("First name: ");
            firstName = console.readLine();
            System.out.print("Last name: ");
            lastName = console.readLine();
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("password: ");
            password= console.readLine();




            User newUser = new User(firstName, lastName, username, password);
            Account newAccount = new Account(0.0, AccountType.CHECKING);
            userService.register(newUser);
            accountService.registerNewAccount(newAccount);
            if(currentUser !=null){
                System.out.println(("[LOG] - New user created! navigating to dashboard..."));

                router.navigate("/select");
            }


        } catch (NumberFormatException | InvalidRequestException | ResourcePersistentException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Unexpected error occurred");
            System.out.println("Shutting down application");
           appRunning=false;
        }
    }
}
