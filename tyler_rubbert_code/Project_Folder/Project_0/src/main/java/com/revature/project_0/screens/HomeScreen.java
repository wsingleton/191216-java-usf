package com.revature.project_0.screens;

import static com.revature.project_0.AppDriver.*;


public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Welcome to Bank.");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");

        try {

            System.out.print("> ");
            String userSelection = app.getConsole().readLine();

            switch (userSelection) {
                case "1":
                    app.getRouter().navigate("/login");
                    break;
                case "2":
                    app.getRouter().navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application...");
                    app.setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("Shutting down application");
            app.setAppRunning(false);
        }
    }
}
