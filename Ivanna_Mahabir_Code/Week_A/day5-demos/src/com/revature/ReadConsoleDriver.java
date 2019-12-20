package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver {

    public static void main(String[] args){

        System.out.println("Printing to the console is easy enough");
        // Reading input from the console using scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("PLease enter your name: ");
        String userName = scanner.next();
        System.out.println("the name you provided: " + userName);


        System.out.println("---------------------------");
        //Reading input from the console using BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name: ");

        //BufferedReader.readline throws the checked exception: IOException
        String name = " "; //if using null
        try {
            name = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("The name you provided is: " + name); //throws NullPointerException if do eg: name.intern()
                                                                    //when the IOException is thrown, when using eg. above

    }

}
