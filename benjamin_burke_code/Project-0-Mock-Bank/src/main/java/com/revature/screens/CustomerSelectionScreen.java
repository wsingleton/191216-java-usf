package com.revature.screens;

import java.io.IOException;

import static com.revature.AppDriver.*;

public class CustomerSelectionScreen extends Screen {
    public CustomerSelectionScreen(String name, String route){
        super("customerSelection", "/select");
    }

    @Override
    public void render(){
        String user = currentUser.getUsername();

        System.out.println("Welcome, " +user + "What would you like to do today?");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Exit");

        try {
            System.out.println("> ");
            String ui = console.readLine();

            switch (ui){
                case "1":
                    router.navigate("/deposit");break;
                case "2":
                    router.navigate("/withdraw");break;
                case "3":
                    System.out.println("Goodbye....");
                    appRunning=false;
                default:
                    System.out.println("invalid input, please pick an option!");
            }
        } catch (IOException e) {
            System.err.println("[ERROR] -" + e.getMessage());
            System.out.println("[LOG]-GoodyBye!");
            appRunning = false;
        }

    }

}
