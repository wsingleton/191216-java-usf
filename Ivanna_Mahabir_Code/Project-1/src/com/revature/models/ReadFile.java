package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List<UserB> ReadFile() {

        // Read file and compare
        File acctFile = new File("src/resources/account.txt");

        List<UserB> userBList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(acctFile));
            String line = reader.readLine();

            while (line != null) {
                String[] userFields = line.split(":");
                //should be reading file and putting data into list

                UserB u = new UserB(userFields[0], userFields[1], Double.parseDouble(userFields[2]));
                userBList.add(u);
                line = reader.readLine();
                //System.out.println("in the while loop"); // testing ----------------------------

            }
            System.out.println("file completed");
            return userBList;
        } catch (Exception e) {
            System.out.println("An exception was thrown here movies");
            e.printStackTrace();
            return userBList;
        }

    }
}
