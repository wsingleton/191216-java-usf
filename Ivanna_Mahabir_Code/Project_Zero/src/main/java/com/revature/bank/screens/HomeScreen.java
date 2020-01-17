package com.revature.bank.screens;

import static com.revature.bank.AppDriver.*;

public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen", "/home");
        System.out.println("[LOG] - instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Welcome to C Bank");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");

        try{
            System.out.println("> ");
            String userSelection = console.readLine();
            switch (userSelection){
                case "1":
                    router.navigate("/login");
                    break;

                case "2":
                    router.navigate("/register");
                    break;

                case "3":
                    System.out.println("Exiting the application\n");
                    appRunning = false;
                    break;

                default:
                    System.out.println("[LOG] - Invalid selection\n\n");
            }
        }
        catch (Exception e){
            System.err.println("[Error] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }
}
