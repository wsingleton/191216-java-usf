package com.revature.screens;

import java.util.Scanner;

public class Out {


    public static void signOut(int id) {

        Scanner scanner = new Scanner(System.in);

        int option = 0;

        System.out.println("1. Make another transaction");
        System.out.println("2. Go Fight EVIL");

        do {
            System.out.println("What is your choice hero? ");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1 or 2");
                System.exit(0);
            }

            switch (option) {

                case 1:
                    Existing.existingUserScreen(id);
                    break;

                case 2:
                    System.out.println("Go and Save the WORLD ");

                    break;
                default:
                    break;

            }
        } while(option != 2 );
        System.exit(0);

    }
}