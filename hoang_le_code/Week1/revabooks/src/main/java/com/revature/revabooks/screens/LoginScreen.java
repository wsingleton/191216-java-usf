package com.revature.revabooks.screens;
import static com.revature.revabooks.AppDriver.*;

import com.revature.revabooks.exceptions.InvalidRequestExceprion;
import com.revature.revabooks.services.UserService;

import javax.security.sasl.AuthenticationException;

public class LoginScreen extends Screen {

    UserService userService;
    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        String username;
        String password;
        try{
            System.out.println("\n\n\n\n\n\n+----------------------------+\n");
            System.out.println("please enter usernam and pass");
            System.out.println("username: ");
            username = console.readLine();
            System.out.println("password: ");
            password = console.readLine();

            userService.authenticate(username,password);

            if(currentUser != null){
                System.out.println("[Log] - success login ");
                router.navigate("/dashboard");
            }

        }
        catch (InvalidRequestExceprion | AuthenticationException e){
            System.out.println("[log[ Invalid login credentials ");
        }
        catch (Exception e){
            System.err.println("[error] -  An unexpected exception  happen");
            appRunning = false;
        }


    }

}