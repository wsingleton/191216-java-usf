package com.liberationbank.screens;

import com.liberationbank.models.Account;
import com.liberationbank.models.User;

import static com.liberationbank.AppDriver.*;

public class HomeScreen extends Screen {
    public HomeScreen(){
        super("HomeScreen", "/home");
        System.out.println("[LOG] - Instantiating "+ super.getName());
    }
    @Override
    public void render() {
         currentUser = null;
         currentAccount = null;
         currentUserAccount = null;
        //System.out.println(currentUser);
        System.out.println("Welcome to Liberation Bank!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");
        System.out.println("NOTE USER WARNING: All invalid user inputs will result in returning to this screen, be cautious.");
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
                    appRunning= false;
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
