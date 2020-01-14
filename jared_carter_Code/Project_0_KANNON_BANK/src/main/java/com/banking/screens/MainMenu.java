package com.banking.screens;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu{
    int option;
    Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Kannon Bank");
        System.out.println("1. Login");
        System.out.println("2. Create an account");
        do {

        System.out.println("Enter an option");
        try {
            String dummy = scanner.next();
            option = Integer.parseInt(dummy);
        } catch (Exception e) {
            System.out.println("Please select a number: ");
        }

        //Switch statement to check for Login or Create a New Account

        option = scanner.nextInt();
        switch (option) {

            case 1:
                loginScreen();
                break;

            case 2:
                createAccount();
                break;

            default:
                System.out.println("Please enter 1 or 2 ");
                System.exit(0);
                break;
        }
    } while(option != 3);

}
}
