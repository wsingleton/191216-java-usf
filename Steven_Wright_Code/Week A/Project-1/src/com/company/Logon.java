package com.company;

import java.io.File;
import java.util.Scanner;

public class Logon {

    public static void logon() {

        File file = new File( "resources\\users.txt");

        Scanner input = new Scanner(System.in);
        String username;
        String password;

        System.out.println("Log in ");
        System.out.println("username ");
        username = input.next();

        System.out.println("password:");
        password = input.next();

        //users check = new users(username, password);

        if(username.equals(username) && password.equals(password))
            System.out.println("You are logged in:");
    }
}
