package com.revature.project0.screens;

import static com.revature.project0.AppDriver.*;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");

    }



    @Override
    public void render() {
        System.out.println("Welcome to Bens bank!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");

        try {

            System.out.print("> ");
            String userSelection = console.readLine();

            switch (userSelection) {

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

        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }

}