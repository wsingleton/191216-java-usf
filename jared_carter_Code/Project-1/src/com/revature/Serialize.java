package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Serialize {
    public static void writeMap(Hashtable map) {

        String filename = "user.txt";
        PrintWriter writer = null;
        Scanner scanner = null;

        try {
            FileWriter fw = new FileWriter(filename, true);
            writer = new PrintWriter(fw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        accountSer
        while (scanner.hasNextLine()) {

            line = scanner.nextLine();
            writer.println(line);

        }
        scanner.close();
        writer.close();
    }
}