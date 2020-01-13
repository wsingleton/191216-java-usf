package com.revature.bankapp.screens;

import static com.revature.bankapp.BankDriver.*;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
    }


    @Override
    public void render() {

        System.out.println("Welcome to Bank of Revature!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");

        try {

            System.out.print("> ");
            String userSelection = console.readLine();

            switch(userSelection) {
                case "1":
                    router.navigate("/login");
                    break;
                case "2":
                    router.navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application...");
                    appRunning = false;
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");
            }


        } catch (Exception e) { e.printStackTrace(); }

    }
}
