package com.revature.screens;

import com.revature.util.ScreenRouter;

import java.util.Scanner;

import static com.revature.MockBankDriver.router;

public class HomeScreen extends Screen {
    public HomeScreen() {
        super("HomeScreen", "/home");
        //System.out.println("[LOG] + Instantiating "+ super.getName());
    }

    @Override
    public void render() {
        System.out.println("Welcome to Mock Bank!");
        System.out.print("Would you like to register (enter 0), login (enter 1), admin (enter 2), or exit (enter 3): ");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.next()){
            case "0":
                router.navigate("/register");
                break;
            case "1":
                router.navigate("/login");
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input!");
                router.navigate("/home");
                break;
        }
    }
}
