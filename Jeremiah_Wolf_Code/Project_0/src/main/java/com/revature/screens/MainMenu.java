package com.revature.screens;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu()

    {

        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Good Morrow, Welcome to UA Bank, PLUS ULTRA!");
        System.out.println("1. Sign Into Current Hero Account");
        System.out.println("2. Create a New Hero Account");
        System.out.println("3. Go Fight EVIL");
        do {

            System.out.println("What is your choice hero?");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1, 2 or 3");
                //System.exit(0);
            }




            switch (option) {

                case 1:

                    Login.logIn();

                    break;

                case 2:
                    Create.createAccount();

                    break;

                case 3:
                    System.out.println("Go and Save the WORLD");

                    break;

                default:
                    break;
            }
        } while(option != 3 );
        System.exit(0);


    }
}