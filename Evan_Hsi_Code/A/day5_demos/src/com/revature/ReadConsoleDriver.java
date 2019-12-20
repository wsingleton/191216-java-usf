package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args) {

        System.out.println("Printing to the console is easy enough");

        Scanner scanner = new Scanner(System.in);
        System.out.print("type something: ");
        String userName = scanner.next();
        System.out.println("NAME: " + userName);

        System.out.println("---------------------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name: ");
        try {
            String name = reader.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
