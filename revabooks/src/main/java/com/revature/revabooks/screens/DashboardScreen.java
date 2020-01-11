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

        System.out.println("Rendering " + currentSession.getSessionUser().getFirstName() + "'s Dashboard...");

        // Display the standard user dashboard (will need to create admin version of dashboard)
        System.out.println("\n\n+---------------------------------+\n");
        System.out.println("1) Search Books");
        System.out.println("2) My Favorite Books");
        System.out.println("3) My Wish List");
        System.out.println("4) Shopping Cart");
        System.out.println("5) Edit Profile");
        System.out.println("6) Sign Out");

        try {

            // Get the user's menu selection
            System.out.print("Selection: ");
            userSelection = console.readLine();

            // Navigate to the appropriate screen based on the user's selection
            switch(userSelection) {
                case "1":
                    // Navigate to the SearchBooksScreen
                    router.navigate("/search");
                    break;
                case "2":
                    // Navigate to the FavoriteBooksScreen
                    router.navigate("/favorites");
                    break;
                case "3":
                    // Navigate to the WishlistScreen
                    System.out.println("WishlistScreen under construction...");
                    break;
                case "4":
                    // Navigate to the ShoppingCartScreen
                    System.out.println("ShoppingCartScreen under construction...");
                    break;
                case "5":
                    // Navigate to the UserProfileScreen
                    router.navigate("/profile");
                    break;
                case "6":
                    System.out.println(currentSession.getSessionUser().getUsername() + " signing out...");
                    currentSession = null;
                    break;
                default:
                    System.out.println("Invalid Selection!");
                    router.navigate("/dashboard");
            }

        } catch (Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }

    }

}
