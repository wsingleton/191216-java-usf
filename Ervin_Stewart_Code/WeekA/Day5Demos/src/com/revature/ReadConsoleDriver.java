package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {
    public static void main(String... args){
//        System.out.println("Printing to the console is easy enough");
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please enter your firstname:");
//        String username = scanner.next();
//        System.out.println("The firstname you provided is: " + username);
//
//        System.out.println("Please enter your lastname:");
//        String lastname = scanner.next();
//        System.out.println("The lastname you provided is: " + lastname);
//
//        String Fullname = username +" "+ lastname;
//        System.out.println(Fullname);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



            System.out.println("please enter your name");
            try {
                String name = reader.readLine();
            } catch (IOException e) {
               e.printStackTrace();


            }


    }

}
