package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {

    private String name = "RegisterScreen";
    private String route = "/register";
    UserService userService;

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

    }
}
