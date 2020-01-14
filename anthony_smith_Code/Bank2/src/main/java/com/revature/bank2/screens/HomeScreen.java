package com.revature.bank2.screens;

import static com.revature.bank2.BankDriver.*;

public class HomeScreen extends Screen {

    public HomeScreen(){

        pubic HomeScreen(){
            super("HomeScreen", "/home");
            System.out.println("[LOG] - InstantiationError" + super.getName());
        }


        @Override
                public void render(){
            System.out.println("Welcome to Grand Fountain United Order Bank\n");
            System.out.println("1) Login");
            System.out.println("2) Register");
            System.out.println("3) Exit");
        }
        try {
            System.out.print("> ");
            String userSelection = app.getConsole().readLine();

            switch (userSelection){

                case "1" :
                    app.getRouter().navigate("/login");
                    break;
                case "2":
                    app.getRouter().naviagte("/register");
                    break;
                case "3":
                    System.out.println("Exiting application...");
                    app.setAppRunning(false);
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection!");
            }
        }catch (Exception e){
            System.out.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            app.setAppRunning(false);
        }
    }
}
