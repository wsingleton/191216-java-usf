package com.revature.screens;

import java.util.Scanner;

public class SignOutScreen {


    public static void signOut(int id) {

        Scanner scanner = new Scanner(System.in);

        int option = 0;

        System.out.println("1. Make another transaction");
        System.out.println("2. Sign out");

        do {
            System.out.println("Enter an option: ");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1 or 2");
                System.exit(0);
            }

            switch (option) {

                case 1:
                    ExistingUserScreen.existingUserScreen(id);
                    break;

                case 2:
                    System.out.println("Thank you for using Kannon Bank.");

                    break;
                default:
                    //System.out.println("Please enter 1, 2");
                    break;

            }
        } while(option != 2 );
        System.exit(0);

    }
}
