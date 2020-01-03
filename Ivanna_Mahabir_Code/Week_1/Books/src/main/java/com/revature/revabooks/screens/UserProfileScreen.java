package com.revature.revabooks.screens;


import com.revature.revabooks.services.UserService;

public class UserProfileScreen extends Screen {

    public UserProfileScreen(){
        super("UserProfileScreen", "/profile");
        System.out.println("[LOG] - instantiating " + super.getName());
    }

    @Override
    public void render() {

    }
}

