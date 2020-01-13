package com.revature.fauxbankextended.screens;

import static com.revature.fauxbankextended.BankDriver.*;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashBoardScreen", "/dashboard");
    }

    @Override
    public void render() {

        System.out.println("1) Check Balance");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Exit Application");
        System.out.println("Please choose an option.");

        try {
            System.out.print("> ");
            String input = app().getConsole().readLine();

            switch (input) {

                case "1":
                    app().getRouter().navigate("/balance");
                    break;
                case "2":
                    app().getRouter().navigate("/deposit");
                    break;
                case "3":
                    app().getRouter().navigate("/withdraw");
                    break;
                case "4":
                    System.out.println("Exiting the application...");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid selection");
                    app().getRouter().navigate("/dashboard");
            }

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

    }
}
