package com.revature.bank2.screens;

import static com.revature.bank2.BankDriver.app;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super("DashboardScreen", "/dashboard");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

        String userSelection;
        boolean loopMenu = true;
        System.out.println("Rendering " + app().getCurrentSession().getSessionUser().getFirstName() + "'s Dashboard...");

        while (loopMenu) {
            System.out.println("1) Withdraw");
            System.out.println("2) Deposit");
            System.out.println("3) Display Balance");
            System.out.println("4) Sign Out");
        }

        try {
            System.out.println("Please enter a Selection: ");
            userSelection = app().getConsole().readLine();

            switch (userSelection){
                case "1":
                    System.out.println("withdraw method");
                    break;

                case "2":
                    System.out.println("deposit method");
                    break;

                case "3":
                    System.out.println("display balance");
                    break;
                case "4":
                    System.out.println(app().getCurrentSession().getSessionUser().getUsername() + " signing out...");
                    loopMenu = false;
                    app().invalidateCurrentSession();
                    break;
                default:
                    System.out.println("Invalid Selection!");

            }

        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            app().setAppRunning(false);
        }
    }

}