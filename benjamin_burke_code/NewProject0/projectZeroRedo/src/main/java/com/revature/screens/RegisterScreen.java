package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Accounts;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.io.IOException;

import static com.revature.AppDriver.app;

public class RegisterScreen extends Screen{

    private UserService userService;
    private AccountService accountService;

    public RegisterScreen(UserService userService, AccountService accountService){
        super("RegisterScreen", "/register");
        System.out.println("instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String firstName;
        String lastName;
        String username;
        String password;

        try{
            System.out.println("\n\n\n\n\n\n\n\n");
            System.out.println("Register New Account\n");

            System.out.println("Username:");
            username = app().getConsole().readLine();
            System.out.println("Password:");
            password = app().getConsole().readLine();




            System.out.println("First Name:");
            firstName = app().getConsole().readLine();
            System.out.println("Last Name:");
            lastName = app().getConsole().readLine();

            User newUser = new User(firstName, lastName, username, password);
            Accounts newAccount = new Accounts(0, 0.);

            userService.register(newUser);
            AccountRepository ar = new AccountRepository();
            ar.save2(newAccount,username);


            if(app().getCurrentSession().getSessionUser() != null){
                System.out.println("New User Created! Logging in...");
                app().getRouter().navigate("/dashboard");
            }
        }
        catch(InvalidRequestException | ResourcePersistenceException e){
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
            e.printStackTrace();
        }
        catch (IOException e){
            System.err.println("An unexpected error occurred");
            System.err.println("Shutting down");
            app().setAppRunning(false);
        }
    }
}
