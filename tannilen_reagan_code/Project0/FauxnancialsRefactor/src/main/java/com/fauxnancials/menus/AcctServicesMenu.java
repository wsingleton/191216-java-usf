package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;
import com.fauxnancials.services.AcctService;

import static com.fauxnancials.util.AnsiColours.ANSI_RED;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class AcctServicesMenu extends Menu {
    private AcctService acctService;
    public AcctServicesMenu(AcctService acctService) {
        super("Account Services", "/new_accts");
        this.acctService=acctService;
    }
    @Override
    public void render() {
        System.out.println("What sort of account would you like to create today?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("");
        System.out.println("Input 'X' to cancel and return to the dashboard.");
        try {
            System.out.print("> ");
            String userSelection = AppDriver.console.readLine();
            switch (userSelection) {
                case "1":
                    acctService.createNewAcct(1);
                    System.out.println("New checking account created.");
                    System.out.println("Returning to dashboard...");
                    AppDriver.router.navigate("/dashboard");
                    break;
                case "2":
                    acctService.createNewAcct(2);
                    System.out.println("New savings account created.");
                    System.out.println("Returning to dashboard...");
                    AppDriver.router.navigate("/dashboard");
                    break;
                case "x":
                case "X":
                    System.out.println("Returning to dashboard...");
                    AppDriver.router.navigate("/dashboard");
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid input.  Please try again." + ANSI_RESET);
            }
        } catch (Exception e) {
            System.out.println(ANSI_RED + "An unexpected exception has occurred.");
            System.out.println("Please try again later." + ANSI_RESET);
            System.out.println("Closing application...");
            AppDriver.appRunning = false;
        }
    }
}
