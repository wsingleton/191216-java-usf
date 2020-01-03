package com.revature.revabooks.screens;
import static com.revature.revabooks.AppDriver.appRunning;
import static com.revature.revabooks.AppDriver.console;

public class HomeScreen extends Screen {

    public HomeScreen() {
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {
        System.out.println("Welcome to Revabooks \n");
        System.out.println("1.   Login");
        System.out.println("2.   Register");
        System.out.println("3.   Exit");

        try {

            System.out.print(">  ");
            String userSelection = console.readLine();
            switch (userSelection){
                case "1":
                    System.out.println("navigating to login screen");
                    break;
                case "2":
                    System.out.println("navigating to register screen");
                    break;
                case "3":
                    System.out.println("exiting application ...");
                    appRunning = false;
                    break;
                default:
                    System.out.println("[log] - Invalid Selection");

            }

        }catch (Exception e){
            System.out.println("[error] - " + e.getMessage());
            System.out.println("[log] - shutting down ");
            appRunning = false;
        }

    }

}