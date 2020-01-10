package com.revature.screens;

public class LoginScreen extends Screen {

    private UserService userService;

    public LoginScreen(UserService userService){
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating" + super.getName());
        this.userService = userService;
    }

}
