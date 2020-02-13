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

//        System.out.println("                             Welcome " + currentUser.getFirstName()
//                + "    \n");
        System.out.println("\nSelect one of the options below to continue \n");
        System.out.println("1) Create a new account");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Log Account History");
//        System.out.println("5) transfer funds");
//        System.out.println("6) Switch to another account");
        System.out.println("5) Check balance");
        System.out.println("6) Log out");

        try {

            System.out.print("> ");
            String userSelection = console.readLine();

            switch (userSelection) {

                case "1":
                    router.navigate("/createAccount");
                    break;
                case "2":
                    router.navigate("/deposit");
                    break;
                case "3":
                    router.navigate("/withdraw");
                    break;
                case "4":
                    router.navigate("/accountHistory");
//                   break;
//                case "5":
//                    router.navigate("/transfer");
//                    break;
//                case "6":
//                    router.navigate("/switch");
                    break;
                case "5":
                    router.navigate("/balance");
                    break;
                case "6":
                    System.out.println("Exiting the application...");
                    appRunning = false;
                    break;
                default:
                    System.out.println("[LOG] - INVALID SELECTION! Try again");
                    //currentUser = null;
                    //currentUser = null;
                    router.navigate("/login");
            }

        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }
}