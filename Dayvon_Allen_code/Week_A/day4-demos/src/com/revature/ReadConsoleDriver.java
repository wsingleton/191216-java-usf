package com.revature;

import java.util.Scanner;

public class ReadConsoleDriver {

    public static  void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println(name);
    }
}
