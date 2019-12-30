package com.banking;

import java.util.Scanner;
import java.io.*;
public class BankingMain {
//private static Scanner x;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        //createfile g = new createfile();

        int user_choice = 2;
        //int user_deposit = 2;

        //display console menu
        //as for log in or create new and validate
        System.out.println("1. Log in");
        System.out.println("2. New Account");
        System.out.println(" input corresponding number");
        user_choice = s.nextInt();
        //user_deposit = s.nextInt();

        if (user_choice != 2) {

                    System.out.println("Input info for account creation");
                    System.out.println("Enter Name (First_Last)");
                     String Username = s.next();
                    System.out.println("Enter password");
                     String Password = s.next();
                // if else for write to txt
            }
        else {
                    System.out.println("Enter UserName");
                    String EUsername = s.next();
                    System.out.println("Enter Password");
                    String EPassword = s.next();
                    // if else for read from txt and verification

        }

    }
}
