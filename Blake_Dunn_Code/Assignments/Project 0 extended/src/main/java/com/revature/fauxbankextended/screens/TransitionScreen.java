package com.revature.fauxbankextended.screens;

import static com.revature.fauxbankextended.BankDriver.*;

public class TransitionScreen extends Screen {

    public TransitionScreen() {
        super("TransitionScreen", "/transition");
    }

    @Override
    public void render(){

        System.out.println("Would you like to perform another transaction?");
        System.out.println("1) Yes");
        System.out.println("2) Logout");
        System.out.println("3) Exit Application");

        try {
            System.out.print("> ");
            String input = app().getConsole().readLine();

            switch (input) {

                case "1":
                    app().getRouter().navigate("/dashboard");
                    break;
                case "2":
                    app().invalidateCurrentSession();
                    app().getRouter().navigate("/home");
                    break;
                case "3":
                    System.out.println("Exiting application...");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection");
                    app().invalidateCurrentSession();
                    app().getRouter().navigate("/home");
            }

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            app().setAppRunning(false);
        }
    }
}
