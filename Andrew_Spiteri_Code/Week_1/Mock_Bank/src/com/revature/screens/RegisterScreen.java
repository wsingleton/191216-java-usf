package com.revature.screens;

import com.revature.services.UserService;

import java.io.IOException;
import java.util.Scanner;

import static com.revature.MockBankDriver.router;

public class RegisterScreen extends Screen {
    private UserService userService;

    public RegisterScreen(UserService userService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] + Instantiating "+ super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {
        System.out.println("Welcome to the Registration Screen");
        Scanner sc = new Scanner(System.in);
        System.out.print("First name: ");
        String firstname =sc.next();
        System.out.print("Last name: ");
        String lastname =sc.next();
        System.out.print("Username: ");
        String username =sc.next();
        System.out.print("Password: ");
        String password =sc.next();
        try{
            UserService.registerUser(firstname, lastname, username, password);
        }catch (IOException ioe){
            System.out.println("Invalid input.");
            router.navigate("/register");
        }


    }
}
