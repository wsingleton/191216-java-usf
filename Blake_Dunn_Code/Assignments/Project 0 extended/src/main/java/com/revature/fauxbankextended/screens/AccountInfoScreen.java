package com.revature.fauxbankextended.screens;

import static com.revature.fauxbankextended.BankDriver.app;

public class AccountInfoScreen extends Screen {

    public AccountInfoScreen(){
        super("AccountInfoScreen", "/info");
    }

    @Override
    public void render() {

        // If user has multiple accounts create method to display each one.

        System.out.println("1) Transaction History");
        System.out.println("2) Add User to Account");
        System.out.println("3) Switch Accounts");
        System.out.println("4) Dashboard");
        System.out.println("5) Sign out");
        System.out.println("6) Exit");
        System.out.println("Select an option.");

        try {
            System.out.print("> ");
            String input = app().getConsole().readLine();

            switch (input) {

                case "1":
                    app().getRouter().navigate("/history");
                    break;
                case "2":
                    app().getRouter().navigate("/addacct");
                    break;
                case "3":
                    app().getRouter().navigate("/switch");
                    break;
                case "4":
                    app().getRouter().navigate("/dashboard");
                    break;
                case "5":
                    app().invalidateCurrentSession();
                    app().getRouter().navigate("/home");
                    break;
                case "6":
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
