package com.reavture.screens;

import java.util.Scanner;

public class HomeScreen {

    public static void home()

    {

        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to New Age Bank");
        System.out.println("1) Login");
        System.out.println("2) Create an account");
        System.out.println("3) Exit");
        do {

            System.out.println("Enter an option: ");
            try {
                String dummy = scanner.next();
                option = Integer.parseInt(dummy);
            } catch (Exception e) {
                System.out.println("Please enter 1, 2 or 3");
            }



            switch (option) {

                case 1:

                    LoginScreen.logIn();

                    break;

                case 2:
                    RegisterScreen.createAccount();

                    break;

                case 3:
                    System.out.println("Thank You");

                    break;

                default:
                    //System.out.println("Please enter 1, 2 or 3");
                    break;
            }
        } while(option != 3 );
        System.exit(0);


    }


}
