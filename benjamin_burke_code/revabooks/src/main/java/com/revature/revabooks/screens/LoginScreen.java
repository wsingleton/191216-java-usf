package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.services.UserService;



import static com.revature.revabooks.AppDriver.*;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService){
        super("LoginScreen","/logIn");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;

        try {
            System.out.println("------------------------------------\n");
            System.out.println("Please provide your login credentials");
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password");
            password = console.readLine();

            userService.authenticate(username, password);


            if (currentUser != null) {
                System.out.println("[LOG] - Login successful, navigating to dashboard...");
                router.navigate("/dashboard");
            }

//        }
//        catch (AuthenticationException e){
//
//            System.out.println("[LOG]-invalid");
//
        } catch (AuthenticationException | InvalidRequestException e ){
            System.out.println("[Log] - Invalid Log In credentials");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("[ERROR] - An unexpected exception occured");
            System.out.println("[LOG] - shutting down application");
            appRunning = false;
        }
    }
}
