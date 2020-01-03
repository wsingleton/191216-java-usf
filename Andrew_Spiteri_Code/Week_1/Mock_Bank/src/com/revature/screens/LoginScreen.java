package com.revature.screens;

import com.revature.repositories.UserRepository;
import com.revature.services.UserService;

import java.util.Scanner;

public class LoginScreen extends Screen {
    private UserService userService;
    private UserRepository userRepository;

    public LoginScreen(UserService userService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] + Instantiating "+ super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        System.out.println("Welcome to Mock Bank. Please login to your account.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        UserService userService = new UserService(userRepository);
        userService.login(username,password);
    }
}
