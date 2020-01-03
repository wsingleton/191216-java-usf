package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {
    public RegisterScreen(){
        super("Registerscreen", "/register");
        System.out.println("[LOG] - instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("register works");
    }
}
