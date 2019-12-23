package com.revature;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args) {

        System.out.println("Printing to the console is easy enough.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String userName = scanner.next();
        System.out.println("The name you provided is: "+ userName);


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();

    }
}
