package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class UserProfileScreen extends Screen {

    private String name = "UserProfileScreen";
    private String route = "/profile";
    UserService userService;

    public UserProfileScreen() {
        super("UserProfileScreen", "/profile");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

    }
}
