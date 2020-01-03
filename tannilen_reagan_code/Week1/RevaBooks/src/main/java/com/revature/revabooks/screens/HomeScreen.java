package com.revature.revabooks.screens;

import com.revature.revabooks.AppDriver;

public class HomeScreen extends Screen {
    public HomeScreen() {
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating " + this.getName());
    }
    @Override
    public void render() {
        System.out.println("Welcome to RevaBooks!\n");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        try {
            System.out.print("> ");
            String userSelection = AppDriver.console.readLine();
            switch (userSelection) {
                case "1":
                    AppDriver.router.navigate("/login");
                    break;
                case "2":
                    AppDriver.router.navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application.  Thank you for using RevaBooks!");
                    AppDriver.appRunning=false;
                    break;
                default:
                    System.out.println("[LOG] - invalid selection.");
            }
        }
        catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.err.println("[LOG] - Closing application.");
            AppDriver.appRunning=false;
        }
    }
}
