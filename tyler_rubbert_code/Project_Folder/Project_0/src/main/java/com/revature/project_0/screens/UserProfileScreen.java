package com.revature.project_0.screens;

import static com.revature.project_0.AppDriver.app;

public class UserProfileScreen extends Screen {

    public UserProfileScreen() {
        super("UserProfileScreen", "/user");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    @Override
    public void render() {

        String userSelection;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome to your profile " + app().getCurrentSession().getSessionUser().getFirstName() + " " + app().getCurrentSession().getSessionUser().getLastName() + ".");
        System.out.println("1) to deposit");
        System.out.println("2) to withdraw");
        System.out.println("3) to logout");

        try {
            userSelection = app().getConsole().readLine();

            switch(userSelection) {

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
