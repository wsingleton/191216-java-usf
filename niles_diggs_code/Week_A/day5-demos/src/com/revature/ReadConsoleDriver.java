package com.revature;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args) {

        System.out.println("Printing to the console is easy enough.");
        // creating input from the console using scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String userName = scanner.next();
        System.out.println("The name you provided is: " + userName);
        System.out.print(" Please provide your age: ");

        int age = -1;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid age :(");
        }
        System.out.println("Your age is: " + age);

        System.out.println("---------------------------");

        // reading input from the console using BufferedReader

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in)); // reader is just an interface, you have the ability to pass any kind of class that implements reader (polymorphism)
        System.out.println("Please enter your name: ");

        //BufferedReader.readline throws the checked exception : IOException
        String name = "";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The name you provided is: " + name);

    }
}
