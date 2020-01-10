package com.fauxnancials.menus;

import com.fauxnancials.AppDriver;

import static com.fauxnancials.AppDriver.screenreader;
import static com.fauxnancials.util.AnsiColours.*;

public class HomeMenu extends Menu {
    public HomeMenu() {
        super("Home", "/home");
    }
    public void render() {
        if (screenreader) {
            System.out.println("Welcome to Fauxnancials Bank!");
            System.out.println("");
        }
        else {
            System.out.println(ANSI_CYAN + "#######                                                                            ######                       ");
            System.out.println("#         ##   #    # #    # #    #   ##   #    #  ####  #   ##   #       ####     #     #   ##   #    # #    # ");
            System.out.println("#        #  #  #    #  #  #  ##   #  #  #  ##   # #    # #  #  #  #      #         #     #  #  #  ##   # #   #  ");
            System.out.println("#####   #    # #    #   ##   # #  # #    # # #  # #      # #    # #       ####     ######  #    # # #  # ####   ");
            System.out.println("#       ###### #    #   ##   #  # # ###### #  # # #      # ###### #           #    #     # ###### #  # # #  #   ");
            System.out.println("#       #    # #    #  #  #  #   ## #    # #   ## #    # # #    # #      #    #    #     # #    # #   ## #   #  ");
            System.out.println("#       #    #  ####  #    # #    # #    # #    #  ####  # #    # ######  ####     ######  #    # #    # #    # " + ANSI_RESET);
            System.out.println("");
        }
        System.out.println("How may we assist you today?\n");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        try {
            System.out.print("> ");
            String userSelection = AppDriver.console.readLine();
            switch (userSelection) {
                case "1":
                    AppDriver.router.navigate("/login");
                    break;
                case "2":
                    AppDriver.router.navigate("/register");
                    break;
                case "3":
                    System.out.println("Exiting application.  Thank you for using Fauxnancials Bank!");
                    AppDriver.appRunning=false;
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid selection.  Please try again." + ANSI_RESET);
            }
        }
        catch (Exception e) {
            System.out.println(ANSI_RED +"An unexpected exception has occurred.");
            System.out.println("Please try again later." + ANSI_RESET);
            System.out.println("Closing application...");
            AppDriver.appRunning=false;
        }
    }
}
