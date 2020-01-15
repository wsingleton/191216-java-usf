package com.revature.fauxbankextended.screens;

import static com.revature.fauxbankextended.BankDriver.app;

public class UserProfileScreen extends Screen {

    public UserProfileScreen(){
        super("AccountInfoScreen", "/profile");
    }

    @Override
    public void render() {

        System.out.println("\n\n");
        System.out.println("Welcome to the your profile screen, " + app().getCurrentSession().getSessionUser().getFirstName() + "\n");
        System.out.println("+----------  Profile Menu  ----------+ \n");

        System.out.println("1) Transaction History");
        System.out.println("2) Create a New Account");
        System.out.println("3) Add user to Current Account");
        System.out.println("4) Switch Accounts");
        System.out.println("5) Dashboard");
        System.out.println("6) Sign out");
        System.out.println("7) Exit");

        try {
            System.out.print("\n> ");
            String input = app().getConsole().readLine();

            switch (input) {

                case "1":
                    app().getRouter().navigate("/history");
                    break;
                case "2":
                    app().getRouter().navigate("/addacct");
                    break;
                case "3":
                    app().getRouter().navigate("/joint");
                    break;
                case "4":
                    app().getRouter().navigate("/switch");
                    break;
                case "5":
                    app().getRouter().navigate("/dashboard");
                    break;
                case "6":
                    app().invalidateCurrentSession();
                    app().getRouter().navigate("/home");
                    break;
                case "7":
                    System.out.println("Exiting the application...");
                    app().setAppRunning(false);
                    break;
                default:
                    System.out.println("Invalid selection");
                    app().getRouter().navigate("/dashboard");
            }

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }
    }
}
