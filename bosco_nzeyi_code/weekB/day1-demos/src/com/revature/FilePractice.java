package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FilePractice {

    public static void main(String... args){
        File myfile = new File("src/resources/users.txt");

        try {
            FileReader reader = new FileReader(myfile);
            BufferedReader read = new BufferedReader(reader);
            String lines = read.readLine();

            ArrayList<String> allLines = new ArrayList<String>();


            while (lines != null){
                allLines.add(lines);
//                System.out.println(lines);
                lines = read.readLine();
            }
            System.out.println("the length is " + allLines.size());
            for(String data: allLines){
//                System.out.println(data);
//                data.split(" ");
//                data.indexOf(0);
                // search the 1st empty location in the string
                int indexOfEmpty = data.indexOf(" ");
                System.out.println("first empty in the string is at index " + indexOfEmpty);
                String userId = data.substring(0, indexOfEmpty);
                Integer idInNumber = new Integer(userId);
                System.out.println("The user id is = " + idInNumber);
            }



        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred");
        }

    }
}
