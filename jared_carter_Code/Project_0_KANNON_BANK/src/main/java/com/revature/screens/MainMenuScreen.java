package com.revature.screens;

import java.util.Scanner;

public class MainMenuScreen {
    public static void mainMenu()

    {

        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Kannon Bank");
        System.out.println("1. Login");
        System.out.println("2. Create an account");
        System.out.println("3. Exit");
        do {

            System.out.println("Enter an option: ");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1, 2 or 3");
                //System.exit(0);
            }

            //Switch statement to check for Login or Create a New Account


            switch (option) {

                case 1:

                    LogInScreen.logIn();

                    break;

                case 2:
                    CreateAccountScreen.createAccount();

                    break;

                case 3:
                    System.out.println("Thank you for using Kannon Bank.");

                    break;

                default:
                    //System.out.println("Please enter 1, 2 or 3");
                    break;
            }
        } while(option != 3 );
        System.exit(0);


    }
}

