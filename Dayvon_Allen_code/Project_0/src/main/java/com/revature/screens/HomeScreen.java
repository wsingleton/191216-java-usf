package com.revature.screens;
import static com.revature.BankDriver.*;

public class HomeScreen extends Screen{
    public HomeScreen() {
        super("HomeScreen", "/home");
    }

    @Override
    public void render() {
        System.out.println("Welcome to Dayvon's Bank!\n");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("3) Exit Application");

        try {
            System.out.print("> ");
            String userSelection = console.nextLine();

            switch (userSelection) {
                case "1":
                    router.navigate("/login");
                    break;
                case "2":
                    router.navigate("/register");
                    break;
                case "3":
                    System.out.println("\n\n\n\n\n\n\n\n--------------------------------");
                    System.out.println("Exiting application...");
                    System.out.println("--------------------------------");
                    console.close();
                    appRunning = false;
                    break;
                default:
                    System.out.println("\n\n\n\n+--------------------------------+");
                    System.out.println("Invalid selection!");
                    System.out.println("+--------------------------------+\n");
            }
        }
        catch (Exception e){
            appRunning = false;
        }
    }
}
