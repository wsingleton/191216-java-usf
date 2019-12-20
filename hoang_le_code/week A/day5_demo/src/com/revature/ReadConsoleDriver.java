package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadConsoleDriver {
    public static void main(String args[]){

        System.out.println("printing to the consol is easy enough");


        Scanner scanner= new Scanner(System.in);
        System.out.println("please enter your name");
        String userName = scanner.next();
        System.out.println("the name you provided is : " + userName);
        //String s = ((Integer)scanner.nextInt()).toString();


        System.out.println("enter your age");
        int age=-1;
        try {
            age = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("invalid age");
        }
        System.out.println("your age is "+ age);



        System.out.println("---------------------------");
        //Reading input from the console using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter some thing");

        // bufferedReader.readline throws the checked exception : IOException
        String name ="";
        try {
            name = reader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("this is the nam you provided : " + name);


    }
}
