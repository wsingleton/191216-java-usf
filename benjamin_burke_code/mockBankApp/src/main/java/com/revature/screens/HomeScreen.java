package com.revature.screens;

import static com.revature.AppDriver.*;

public class HomeScreen extends Screen {

    public HomeScreen(){
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating" + super.getName());
    }

    @Override
    public void render(){
        currentUser=null;
        currentAccountUser=null;
        cuurentAccount=null;
        System.out.println("Welcome to Bens Bank!");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit");

        try {
            System.out.println("> ");
            String userInput = console.readLine();

            switch (userInput){
                case "1":
                    router.navigate("/login"); break;
                case "2":
                    router.navigate("/register"); break;
                case "3":
                    System.out.println("Goodbye");
                    appRunning=false;

            }
        } catch (Exception e){
            System.out.println("[ERROR] -" + e.getMessage());
            System.out.println("Shutting down application");
            appRunning=false;
        }
    }
}
