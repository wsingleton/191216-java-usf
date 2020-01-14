package com.revature.screens;

import java.util.Scanner;

public class SignOutScreen {


    public static void signOut(int id) {

        Scanner scanner = new Scanner(System.in);

        int option = 0;

        boolean valid = false;

        System.out.println("1. Complete another transaction");
        System.out.println("2. Sign out");

        do {
            System.out.println("Enter an option: ");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please select a number: ");
            }

            switch (option) {

                case 1:
                    ExistingUserScreen.existingUserScreen(id);
                    break;

                case 2:
                    System.out.println("Thank you for using Kannon Bank.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid choice");
                    break;

            }
        } while(false);

    }
}
