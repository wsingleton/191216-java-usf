package com.revature.revabooks.screens;

import static com.revature.revabooks.AppDriver.*;

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

            System.out.println("\n\n+---------------------------------+\n");
            System.out.println("1) Search Books");
            System.out.println("2) My Favorite Books");
            System.out.println("3) My Wish List");
            System.out.println("4) Shopping Cart");
            System.out.println("5) Edit Profile");
            System.out.println("6) Sign Out");

            try {

                System.out.print("Selection: ");
                userSelection = app().getConsole().readLine();

                switch (userSelection) {
                    case "1":
                        app().getRouter().navigate("/search");
                        break;
                    case "2":
                        System.err.println("FavoritesScreen under construction...");
                        break;
                    case "3":
                        System.err.println("WishlistScreen under construction...");
                        break;
                    case "4":
                        System.err.println("ShoppingCartScreen under construction...");
                        break;
                    case "5":
                        app().getRouter().navigate("/profile");
                        break;
                    case "6":
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

}
