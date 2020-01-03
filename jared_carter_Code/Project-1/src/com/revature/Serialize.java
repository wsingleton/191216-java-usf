package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Serialize {
    public void writeMap(Hashtable<Integer, Account> map) {

        String filename = "C:\\Users\\Jared\\repos\\191216-java-usf\\jared_carter_Code\\Project-1\\src\\users";
        FileWriter fw = null;

        try {
            fw = new FileWriter(filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter writer = new PrintWriter(fw);
        map.forEach((k,v) -> writer.println(v.accountSerialize()));
        writer.close();
    }
}