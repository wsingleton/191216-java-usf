package com.revature.revabooks.screens;

import com.revature.revabooks.AppDriver;
import static com.revature.revabooks.AppDriver.*;

public class HomeScreen extends Screen {


    public HomeScreen() {
        super("HomeScreen", "/home");
        System.out.println("[LOG] + Instantiating "+ super.getName());
    }

    public void render() {
        System.out.println("Welcome to Revabooks!\n");
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
                    System.out.println("Exiting app...");
                    System.exit(0);
                    appRunning = false;
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection! ");
            }
        }catch (Exception e){
            System.err.println("[Error] "+e.getMessage());
            System.out.println("[LOG] - Shutting down app");
            appRunning = false;
        }
    }
}
