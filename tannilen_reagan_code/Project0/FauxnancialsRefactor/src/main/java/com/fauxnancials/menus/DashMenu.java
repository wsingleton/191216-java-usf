package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;

import java.io.IOException;
import java.time.LocalTime;

import static com.fauxnancials.util.AnsiColours.ANSI_RED;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class DashMenu extends Menu {
    public DashMenu() {
        super("Dashboard", "/dashboard");
    }
    @Override
    public void render() {
        LocalTime time = LocalTime.now();
        LocalTime noon = LocalTime.parse("12:00:00");
        LocalTime evening = LocalTime.parse("18:00:00");
        int morningCheck = time.compareTo(noon);
        if (morningCheck > 0) {
            int afternoonCheck = time.compareTo(evening);
            if (afternoonCheck > 0) {
                System.out.println("Good evening, " + AppDriver.currentUser.getGivenName() + ".");
            } else {
                System.out.println("Good afternoon, " + AppDriver.currentUser.getGivenName() + ".");
            }
        } else {
            System.out.println("Good morning, " + AppDriver.currentUser.getGivenName() + ".");
        }
        System.out.println("What would you like to do today?");
        System.out.println("1. view accounts and balances");
        System.out.println("2. make a deposit");
        System.out.println("3. make a withdrawal");
        System.out.println("4. transfer funds");
        System.out.println("5. open a new account");
        System.out.println("");
        System.out.println("Input 'X' to logout");
        try {
            System.out.print("> ");
            String userSelection = AppDriver.console.readLine();
            switch (userSelection) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "x":
                case "X":
                    System.out.println("Logging out...");
                    AppDriver.currentUser = null;
                    System.out.println("Returning to main menu...");
                    AppDriver.router.navigate("/home");
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
