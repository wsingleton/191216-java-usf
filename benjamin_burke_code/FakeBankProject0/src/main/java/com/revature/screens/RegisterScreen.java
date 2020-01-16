package com.revature.screens;

import com.revature.AppDriver;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Account;
import com.revature.models.AccountUser;
import com.revature.models.User;
//import com.revature.services.AccountService;
import com.revature.repos.AccountRepository;
import com.revature.repos.AccountUserRepository;
import com.revature.repos.UserRepository;
import com.revature.services.AccountService;
import com.revature.services.UserService;

import java.io.IOException;

import static com.revature.AppDriver.*;

public class RegisterScreen extends Screen {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private AccountUserRepository accountUserRepository;
    private UserService userService;
    private AccountService accountService;
    private AccountUserService accountUserService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register")
        System.out.println("[LOG] - Instantiating " + super.getName());;
        this.userService = userService;
    }

    @Override
    public void render() throws IOException {
        String username;
        String password;
        int id;

        try{
            System.out.println("\n\n\n\n\n\n\n\n\n\n+------------------------------------+");
            System.out.println("Sign up for a new account");
            System.out.print("Username: ");
            username = app().getConsole().readLine();
            System.out.print("Password: ");
            password = app().getConsole().readLine();
            id = username.toLowerCase().hashCode();

            User newUser = new User( id, username.toLowerCase(),password);
            userService.register(newUser);
            Account newAccount = new Account()

            if (currentUser != null) {
                router.navigate("/home");
            }
        } catch (InvalidRequestException | ResourcePersistenceException e){
            System.out.println("Login credentials taken!");
            router.navigate("/home");
        }
        catch (Exception e){
            System.err.println("Shutting down application...");
            AppDriver.appRunning = false;
        }    }
}
