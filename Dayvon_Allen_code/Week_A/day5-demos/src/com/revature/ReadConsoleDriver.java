package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        String name;

        System.out.print("Input your name: ");
        name = scanner.next();

        System.out.println(name);

        System.out.println("+-----------------------------------------------+");

        //reading data from the console using bufferedReader

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name: ");
        String name2 = null;
        //necessary for buffered reader
        try {
             name2 = reader.readLine();
        } catch (IOException e) {
            //prints the exception and shows you where it comes from.
            e.printStackTrace();
        }

    }
}
