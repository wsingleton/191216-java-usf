package com.bank.dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class ReadFile {

    public static void checkLogIn(String un) {
        BufferedReader getIt = new BufferedReader(new InputStreamReader(System.in));


        try {
            // Open the file that is the first command line parameter
            FileInputStream stream = new FileInputStream(
                    "C:/Users/bdunn/OneDrive/Desktop/repos/191216-java-usf/Blake_Dunn_Code/Project -1/Users.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(stream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            un = getIt.readLine();

            while ((strLine = br.readLine()) != null) {
                // Print the content on the console#
                if (userName.equals(strLine)) {
                    System.out.println("You have login!");
                } else {
                    System.out.println("Invalid PIN!");
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
