package com.revature.models;

import java.util.Scanner;
// implement a read input from console using method overloading
// so this can be used for multiple inputs, such as integer,
// strings, double, combi, etc

//working Progress!!!

public class ReadInput {
    static Integer readIn(Integer option){
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        return option;
    }
    static Double readIn(Double option){
        Scanner scanner = new Scanner(System.in);
        scanner.nextDouble();
        return option;
    }
    static String readIn(String option){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        return option;
    }
}
