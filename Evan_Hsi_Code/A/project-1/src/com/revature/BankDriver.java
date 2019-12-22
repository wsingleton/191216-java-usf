package com.revature;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Scanner;

public class BankDriver {

    public static void main(String[] args) {

        Bank bank = new Bank();

        //Testing reading from file to makeUser();

        String path = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/userBase.txt";
        File file = new File(path);
        Scanner scanner = null;
        try {scanner = new Scanner(file); } catch (FileNotFoundException fnf) { System.out.println("File not Found"); }

        while(scanner.hasNext()) {
            bank.makeUser(scanner, true);
        }

        bank.userBase.forEach((k,v)->System.out.println(v.serialString()));

        //Testing output format to console
/*
        System.out.println("Testing serialString() method: ");
        User user = new User("Evan", "Hsi", "evanhsi", "12345", Role.ADMIN);
        bank.userBase.put(user.getId(), user);
        System.out.println(user.serialString());
 */

        //Testing reading in a user from console + lookup in the database
        int testId1;
        testId1 = bank.makeUser(new Scanner(System.in), false);
        //System.out.println("Exited makeUser()");

        User user1 = bank.userBase.get(testId1);
        System.out.println(user1.serialString());

        //testing writing users to file
        bank.serializeUser();
    }
}
