package com.revature;

import java.io.*;

public class ReadFileDriver {

    public static void main(String[] args) throws FileNotFoundException {

        File happyText = new File("src/resources/readme.txt");
        System.out.println("Does the file exist?  : : " + happyText.exists());

        try {

            BufferedReader reader = new BufferedReader(new FileReader(happyText));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (IOException ioe) {

            System.err.println("Exception thrown while reading.");

        } catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }

        System.out.println("+---------------------------------------------------------------+");

        File users = new File("src/resources/users.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(users));


        }
    }

}
