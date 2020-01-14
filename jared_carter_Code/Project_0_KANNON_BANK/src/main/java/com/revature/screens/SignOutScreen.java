package com.revature.screens;

import java.util.Scanner;

public class SignOutScreen {

    public static void signOut(int id) {

        Scanner scanner = new Scanner(System.in);

        int optional;

        System.out.println("1. Complete another transaction");
        System.out.println("2. Sign out");


        optional = scanner.nextInt();

        switch (optional) {

            case 1:
                ExistingUserScreen(id);
                break;

            case 2:
                System.out.println("Thank you for using Kannon Bank.");
                System.exit(0);
                break;
            default:
                System.out.println("Not a valid choice");
                break;

        }


    }
}
