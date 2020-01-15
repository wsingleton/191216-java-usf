package com.revature.fauxbankextended.screens;

import static com.revature.fauxbankextended.BankDriver.*;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashBoardScreen", "/dashboard");
    }

    @Override
    public void render() {

        System.out.println("\n\n\n\n\n");
        System.out.println("1) Check Balance");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Transfer Money");
        System.out.println("5) Profile");
        System.out.println("6) Sign out");
        System.out.println("7) Exit");
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
                    app().getRouter().navigate("/transfer");
                    break;
                case "5":
                    app().getRouter().navigate("/profile");
                    break;
                case "6":
                    app().invalidateCurrentSession();
                    app().getRouter().navigate("/home");
                    break;
                case "7":
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
