package com.revature;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {
    public static void main(String[] args){
        System.out.println("Printing to the console is easy.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String userGiven = scanner.next();
        System.out.println("Thank you, " + userGiven + "!");
        System.out.println("What would you like to do today?");
        System.out.println("1. hear a joke");
        System.out.println("2. share a smile");
        System.out.println("3. nothing, I'm done");
        int ans=0;
        try {
            ans = scanner.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("Did you hear about the monkeys who shared an Amazon account? They were Prime mates.");
                    break;
                case 2:
                    System.out.println(":D");
                    break;
                case 3:
                    System.out.println("Okay, goodbye!");
                    break;
                default:
                    System.out.println("Sorry, I didn't get that.  Try again, later.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        System.out.println("+-----------------------------------------------------------+");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter your family name: ");
        String familyName=null;
        try {
            familyName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (familyName==null){
            System.out.println("It's very nice to meet you, " + userGiven + "!");
        }
        else {
            System.out.println("It's very nice to meet you, " + userGiven + " " + familyName + "!");
        }
        System.out.println("Thank you for visiting today, " + userGiven + ".");
        switch (ans) {
            case 1:
                System.out.println("Did you enjoy your joke?");
                break;
            case 2:
                System.out.println("We hope you're able to pass today's smile forward!");
            default:
                System.out.println("We hope to see you again soon!");
        }
    }
}