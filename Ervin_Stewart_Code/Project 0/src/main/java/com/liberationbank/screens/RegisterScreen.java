package com.liberationbank.screens;

import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.Account;
import com.liberationbank.models.AccountType;
import com.liberationbank.models.User;
import com.liberationbank.services.AccountService;
import com.liberationbank.services.UserService;

import static com.liberationbank.AppDriver.*;
import static com.liberationbank.models.AccountType.CHECKING;

public class RegisterScreen extends Screen {
    private UserService userService;
    private AccountService accountService;

    public RegisterScreen(UserService userService, AccountService accountService){
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating "+ super.getName());
        this.userService = userService;
        this.accountService = accountService;
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
            System.out.println("NOTE: Username's are unique, the username you create may be taken." +
                    "Be creative.");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.println("NOTE: The password must contain a special character," +
                    " and be between 8 and 15 characters long.");
            System.out.print("password: ");
            password= console.readLine();

            User newUser = new User(firstname,lastname,username,password);
            Account newAccount = new Account(0.0, AccountType.CHECKING);
            userService.register(newUser);
            accountService.createNewAccount(newAccount);
            if(currentUser != null){
                System.out.println("[LOG] - New user created! navigating to dashboard...");

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
