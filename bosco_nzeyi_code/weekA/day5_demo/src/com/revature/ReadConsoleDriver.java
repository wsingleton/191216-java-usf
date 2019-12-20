
/*
This class will work us through printing vars to the console.
We will also use it to read user input from the console.
 */
package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args) {

        // printing to the console
        System.out.println("printing to the console is easy! ");

        // To read from the console, we need to import Scanner class.
        // inside the scanner we add system in to read the console.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert your name");
        String userName = scanner.next(); // using the scanner constructor we've already created to read from the console.
        System.out.println("The username you provided is " + userName);
        System.out.println(" n/----------------------------------------------------- n/");


        // Reading the console using BufferedReader

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name");

        // we have to wrap the code below into try and catch because the BufferedReader throws IOE Exception. We can also add throw IOE Exception in the main method
        // IOE actually stands for Input and Output exception.
        String name = null;

        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The name you entered is " + name);
    }
}
