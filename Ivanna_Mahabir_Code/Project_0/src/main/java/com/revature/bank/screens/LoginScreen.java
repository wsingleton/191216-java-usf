package com.revature.bank.screens;

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
            System.out.println("Username: ");
            username = console.readLine();
            System.out.println("Password: ");
            password = console.readLine();

            userService.authenticate(username, password);
        }
            catch(){

        }
    }
}
