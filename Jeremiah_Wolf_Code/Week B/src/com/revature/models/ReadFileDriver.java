package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

    public static void main(String[] args){

    File happyMistakes = new File("src/resources/readme.txt");
    System.out.println("Does file exist? :: " + happyMistakes);

    try  {
        BufferedReader reader = new BufferedReader(new FileReader(happyMistakes));
        String line = reader.readLine();

        while (line != null){
            System.out.println(line);
            line = Ireader.readline();
        }
    }

    catch (IOException ioe){
        System.err.println("Exception thrown while reading file.");
    }

    catch(Exception e){
        System.err.println("Unexpected exception.");

    }

    }

}
