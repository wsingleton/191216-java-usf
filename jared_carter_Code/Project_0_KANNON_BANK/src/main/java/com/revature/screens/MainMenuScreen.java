package com.revature.screens;

import java.util.Scanner;

public class MainMenuScreen {
    public static void mainMenu()

    {
        boolean valid = false;
        int option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Kannon Bank");
        System.out.println("1. Login");
        System.out.println("2. Create an account");
        System.out.println("3. Sign out");
        do {

            System.out.println("Enter an option: ");
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

                    LogInScreen.logIn();

                    break;

                case 2:
                    CreateAccountScreen.createAccount();

                    break;

                case 3:
                    System.out.println("Thank you for using Kannon Bank.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter 1 or 2 ");
                    break;
            }
        } while (false);


    }
}

