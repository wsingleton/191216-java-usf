package com.liberationbank.screens;

import static com.liberationbank.AppDriver.console;
import static com.liberationbank.AppDriver.router;
import static com.liberationbank.AppDriver.appRunning;

public class HomeScreen extends Screen {
    public HomeScreen(){
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating "+ super.getName());
    }
    @Override
    public void render() {
        System.out.println("Welcome to Liberation Bank!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");
        try{
            System.out.println("> ");
            String userSelection = console.readLine();

            switch (userSelection){
                case "1":
                    System.out.println("navigating to login Screen");
                    router.navigate("/login");
                    break;
                case "2":
                    System.out.println("navigating to register screen");
                    router.navigate("/register");
                    break;
                case "3":
                    System.out.println("exiting program....");
                    break;
                default:
                    System.out.println("[LOG] - Invalid Selection");
            }
        }
        catch(Exception e){
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;

        }

    }
}
