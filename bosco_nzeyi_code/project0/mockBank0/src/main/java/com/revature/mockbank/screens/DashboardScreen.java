package com.revature.mockbank.screens;

import com.revature.mockbank.models.Account;

import static com.revature.mockbank.AppDriver.*;
import static com.revature.mockbank.AppDriver.appRunning;

public class DashboardScreen extends Screen {

    private Account accountNumber;
    private int noOfAccounts;
    private double balance;



    public DashboardScreen(){
        super("DashboardScreen", "/dashboard");
        System.out.println("Initializing " + super.getName());
    }

    @Override
    public void render() {

        System.out.println("\n                                 MOCKBANK \n");
        System.out.println("                             Welcome " + currentUser.getFirstName()
                + "    \n");
        System.out.println("You have " + " [NUMBER OF ACTIVE ACCOUNTS] account(s) \n");
        System.out.println("Account in use: " + "[Account number] \n");
        System.out.println("Select one of the options below to continue \n");
        System.out.println("1) Create a new account");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Log account history");
        System.out.println("5) transfer funds");
        System.out.println("6) Switch to another account");
        System.out.println("7) Check balance");

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
                    System.out.println("[LOG] - INVALID SELECTION! Try again");
            }

        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}
