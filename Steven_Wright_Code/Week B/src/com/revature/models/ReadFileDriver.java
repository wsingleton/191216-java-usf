
package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {
    public static void main(String[] args){
        File happtText = new File("src/com/revature/resources/readme.txt");
        System.out.println(" does the file exist : " + happtText.exists());
        try{
            BufferedReader reader = new BufferedReader(new FileReader(happtText));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }


        }catch(IOException e){
            System.err.println("exception throw while reading file ");
        }

        catch(Exception e){
            System.err.println("an unexcpected exception occurred");

        }

    }
}

