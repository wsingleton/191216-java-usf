package com.revature.revabooks.screens;

public class RegisterScreen extends Screen {

    public RegisterScreen() {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("register works!");
    }

}
