package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class RegisterScreen extends Screen {

    public RegisterScreen() {
        super("RegisterScreen","/register");
        System.out.println("[Log] - Instantiating" + super.getName());
    }


    @Override
    public void render() {
        System.out.println("register works!");
    }
}
