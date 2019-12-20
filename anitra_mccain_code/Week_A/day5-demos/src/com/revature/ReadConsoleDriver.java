package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args) {

        System.out.println("Printing to the console is easy enough.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");

        String userName = scanner.next();
        System.out.println("The name you provided is: " + userName);
        System.out.println("Please provide your age: ");

        int age = -1;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Value");
        }
        System.out.println("Your age is: " + age);

        System.out.println("+-------------------------------------------------------+");

        //Reading input from the console using BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name: ");

        //BufferedReader.readLine throws the checked exception: IOException
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();//shows you where the error is in the console
        }

        System.out.println("The name you entered is: " + name);
    }
}
