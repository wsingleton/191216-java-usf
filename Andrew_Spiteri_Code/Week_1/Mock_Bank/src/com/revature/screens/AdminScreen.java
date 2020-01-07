package com.revature.screens;

import com.revature.services.UserService;

import java.util.Scanner;

public class AdminScreen extends Screen {

    private UserService userService;

    public AdminScreen(UserService userService) {
        super("AdminScreen", "/admin");
        System.out.println("[LOG] + Instantiating "+ super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Login:");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();


    }
}
