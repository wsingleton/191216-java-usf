package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileDriver {
    public static void main(String[] args) {
        File happyText = new File("src/com/revature/resources/readme.txt");
        System.out.println("Does the file the Exist? :: " + happyText.exists());

        try {
            BufferedReader reader = new BufferedReader((new FileReader(happyText)));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }
    }
}
