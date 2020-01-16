package com.revature.screens;

import static com.revature.AppDriver.app;

public class UserSelectionScreen extends Screen {

    public UserSelectionScreen() {
        super("UserSelectionScreen", "/select");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

        String userInput;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome to your profile " + app().getCurrentSession().getSessionUser().getUsername() + ".");
        System.out.println("1) to deposit");
        System.out.println("2) to withdraw");
        System.out.println("3) to logout");

        try {
            userInput = app().getConsole().readLine();

            switch(userInput) {

                case "1":
                    app().getRouter().navigate("/deposit");
                    break;
                case "2":
                    app().getRouter().navigate("/withdraw");
                    break;
                case "3":
                    app().getRouter().navigate("/home");
                    break;
                default:
                    System.out.println("invalid selection");

            }
        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("Shutting down application");
            app().setAppRunning(false);
        }

    }
}
