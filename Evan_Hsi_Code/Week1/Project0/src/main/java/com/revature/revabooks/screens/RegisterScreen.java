package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {

    private UserService userv;

    public RegisterScreen(UserService userv) {
        super("RegisterScreen", "/register");
        this.userv = userv;
        System.out.println("[LOG] - Instantiating " + super.getName() + " with User Service.");
    }

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public void render() {
        System.out.println("Register works!");
    }
}
