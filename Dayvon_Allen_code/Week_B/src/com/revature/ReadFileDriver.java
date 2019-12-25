package com.revature;

import com.revature.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDriver {
    public static void main(String[] args) {
        File happyText = new File("src/com/revature/resources/readme.txt");
        System.out.println("Does the file the Exist? :: " + happyText.exists());

        try {
            BufferedReader reader = new BufferedReader((new FileReader(happyText)));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (Exception e) {
            System.err.println("An unexpected exception");
        }

        File users = new File("src/com/revature/resources/users.txt");
        List usersList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader((new FileReader(users)));
            String userLine = reader.readLine();

            while (userLine != null) {
                String[] userFields = userLine.split(":");
                User u = new User(userFields[1], userFields[2], Integer.parseInt(userFields[0]));
                usersList.add(u);
                userLine = reader.readLine();
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println("Unexpected File read exception");
        }

    }
}
