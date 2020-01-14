package com.revature.screens;

import com.revature.AppDriver;
import com.revature.exceptcions.InvalidRequestException;
import com.revature.exceptcions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.services.UserService;

import static com.revature.AppDriver.*;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;
        int accountID;

        try{
            System.out.println("\n\n\n\n\n\n\n\n\n\n+------------------------------------+");
            System.out.println("Sign up for a new account");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();
            accountID = username.toLowerCase().hashCode();

            User newUser = new User( accountID, username.toLowerCase(),password);
            userService.register(newUser);

            if (currentUser != null) {
                router.navigate("/customer");
            }
        } catch (InvalidRequestException | ResourcePersistenceException e){
            System.out.println("-------------------------------");
            System.out.println("Invalid data or username is taken!");
            System.out.println("-------------------------------\n\n");
            router.navigate("/home");
        }
        catch (Exception e){
            System.err.println("Shutting down application...");
            AppDriver.appRunning = false;
        }    }
}
