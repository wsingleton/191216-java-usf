package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsleDriver {

    public static void main(String[] args){

        System.out.println("Printing to the console is mad easy");

        //Reading input from console using Scanner
        Scanner scanner = new Scanner(System.in); // constructor to read from console
        System.out.print("Please enter your name: ");
        String userName = scanner.next();         // system reads input
        System.out.println("The name you provided is: " + userName);
        // String s = scanner.nextInt(); // err
        int age = -1;
        System.out.println("Please enter your age");
                try {
                    age = scanner.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Invalid value");
                }
        System.out.println("The age you entered is: " + age);

        System.out.println("+-------------------------------------------------+");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name: ");




        /* BufferedReader.readLine throws the checked exception: IOException */
        String name = "";
        try{
             name = reader.readLine();
         } catch (IOException e) {
                e.printStackTrace();
        }

        System.out.println("The name you provided is: " + name);
        }
}
