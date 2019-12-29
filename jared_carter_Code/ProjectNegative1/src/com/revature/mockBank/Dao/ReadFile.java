package com.revature.mockBank.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public static void main(String[] args) {

        File accountFile("src/resources/readme.txt");
        System.out.println("Does the file exist? :: " + happyText.exists());

        try {

            BufferedReader reader = new BufferedReader(new FileReader(happyText));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (IOException ioe) {
            System.err.println("Exception thrown while reading file.");
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred.");
        }

        System.out.println("+---------------------------+");

        File users = new File("src/resources/users.txt");
        List<User> usersList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(users));
            String userLine = reader.readLine();

            while (userLine != null) {
                String[] userFields = userLine.split(":");
                User u = new User(Integer.parseInt(userFields[0]), userFields[1], userFields[2]);
                usersList.add(u);
                userLine = reader.readLine();
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception occurred.");
        }

        for (User u : usersList) System.out.println(u);

    }
}
