package com.fauxnancials.menus;

import com.fauxnancials.services.UserServices;

public class Register extends Menu {
    private UserServices userService;
    public Register(UserServices userService) {
        super("Register", "/register");
        System.out.println("[LOG] - Instantiating " + this.getName());
        this.userService=userService;
    }
    @Override
    public void render() {
        System.out.println("To be implemented: register menu");
    }
}
