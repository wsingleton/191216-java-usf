package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadConsoleDriver{

public static void main(String[] args){
    Scanner scanner = new Scanner (System.in);
    System.out.print("Please enter your name");
    String userName = scanner.next();
    System.out.println("The name you provided is: " +userName);
    System.out.println("+----------------------+");

    ///Reading input from the console using BufferReader
   /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter your name: ");
    try {
        String name = reader.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }*/
}

}
