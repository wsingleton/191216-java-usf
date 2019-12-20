package com.transfer;

import com.transfer.models.User;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import com.transfer.WriteFile;

public class MainDriver {

    public static void main(String[] args) throws IOException {

        String fileName = "C:/Users/bdunn/OneDrive/Desktop/repos/191216-java-usf/Blake_Dunn_Code/Practice Code/data transfer/test.txt";
        try {
            ReadFile file = new ReadFile(fileName);
            String[] aryLines = file.OpenFile();

            for(int i = 0; i < aryLines.length; i++) {
                System.out.println(aryLines[i]);
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        WriteFile data = new WriteFile(fileName, true);
        data.writeToFile("This is another line of text");

        System.out.println("Text File Written To");

    }
}
