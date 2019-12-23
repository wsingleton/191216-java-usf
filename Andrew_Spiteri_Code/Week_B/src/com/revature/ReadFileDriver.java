package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
    public static void main(String[] args) {
        File rossText = new File("src/resources/readme.txt");
        System.out.println("Does the file exist? :: " + rossText.exists());
        try{
            BufferedReader reader = new BufferedReader(new FileReader(rossText));
            String line = reader.readLine();

            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
            System.err.println("Exception thrown while reading a file.");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An unexpected exception was caught.");
        }
    }
}
