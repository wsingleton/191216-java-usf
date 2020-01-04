package com.revature.revabooks.screens;

import com.revature.revabooks.services.UserService;

public class UserProfileScreen extends Screen {
    private UserService userv;

    public UserProfileScreen(UserService userv) {
        super("UserProfileScreen", "/userprofile");
        this.userv = userv;
        System.out.println("[LOG] - Instantiating " + super.getName() + " With User Service.");
    }

    public UserProfileScreen() {
        super("UserProfileScreen", "/userprofile");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public void render() {
        System.out.println("UserProfileScreen");
    }
}
