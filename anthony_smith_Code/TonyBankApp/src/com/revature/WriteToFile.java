package com.revature;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;

public class WriteToFile {
    private String filename;

    public  void writeMap(HashMap<String, User> userDb) {


        String filename = "/Users/Kusher/Documents/batch_repos/191216-java-usf/anthony_smith_Code/TonyBankApp/src/com/revature/database";

        FileWriter fw = null;

        try {
            fw = new FileWriter(filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter writer = new PrintWriter(fw);
        userDb.forEach((k,v) -> writer.println(v.accountSerialize()));
        writer.close();
    }
}


