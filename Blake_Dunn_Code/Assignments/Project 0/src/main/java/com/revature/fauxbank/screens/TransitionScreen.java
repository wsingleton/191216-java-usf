package com.revature.fauxbank.screens;

import static com.revature.fauxbank.BankDriver.*;
import static com.revature.fauxbank.BankDriver.router;

public class TransitionScreen extends Screen {

    public TransitionScreen() {
        super("TransitionScreen", "/transition");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render(){

        System.out.println("Would you like to perform another transaction?");
        System.out.println("1) Yes");
        System.out.println("2) Logout");
        System.out.println("3) Exit Application");

        try {
            System.out.print("> ");
            String input = console.readLine();

            switch (input) {

                case "1":
                    router.navigate("/dashboard");
                    break;
                case "2":
                    router.navigate("/home");
                    break;
                case "3":
                    System.out.println("Exiting application...");
                    appRunning = false;
                    break;
                default:
                    System.out.println("[LOG] - Invalid selection");
                    router.navigate("/home");
            }

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }
    }
}
