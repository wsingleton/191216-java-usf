package com.revature.screens;
import static com.revature.BankDriver.*;

public class CustomerPortalScreen extends Screen {
    boolean showWelcome = true;

    public CustomerPortalScreen(String name, String route) {
        super(name, route);
    }

    @Override
    public void render() {

        String user = currentUser.getUsername();
        if(showWelcome) {
            System.out.println("\n\n-------------------------------");
            System.out.println("Welcome " + user + "!");
            System.out.println("-------------------------------\n");
        }
        if(!showWelcome) {
            System.out.println("-------------------------------");
        }
        System.out.println("Welcome to the customer portal\n");
        System.out.println("1) Deposit Money");
        System.out.println("2) Withdraw Money");
        System.out.println("3) Show Balance");
        System.out.println("4) Logout");


        try {
            System.out.print("> ");
            String userSelection = console.nextLine();

            switch (userSelection) {
                case "1":
                    showWelcome = false;
                    router.navigate("/deposit");
                    break;
                case "2":
                    showWelcome = false;
                    router.navigate("/withdraw");
                    break;
                case "3":
                    showWelcome = false;
                    router.navigate("/balance");
                    break;
                case "4":
                    System.out.println("\n\n\n\n\n\n\n\n--------------------------------");
                    System.out.println(currentUser.getUsername() + " is now logged out...");
                    System.out.println("--------------------------------");
                    showWelcome = true;
                    router.navigate("/home");
                    break;
                default:
                    System.out.println("\n\n+--------------------------------+");
                    System.out.println("Invalid selection!");
                    System.out.println("+--------------------------------+");
                    showWelcome = false;
                    router.navigate("/customer");
                    break;
            }
        }
        catch (Exception e){
            appRunning = false;
        }
    }
}
