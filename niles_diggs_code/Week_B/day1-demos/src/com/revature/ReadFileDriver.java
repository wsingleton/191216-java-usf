package com.revature;

import com.revature.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDriver {

    public static void main(String[] args) {

        File happyText = new File("src/resources/readme.txt");
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
        } // run the catch blocks in order, always do most specific to least specific
        catch (Exception e) {
            System.err.println("An unexpected error occured :(");
        }



        File users = new File("src/resources/users.txt");
        List<User> userList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(users));
            String userLine = reader.readLine();

            while (userLine != null) {
                String[] userFields = userLine.split(":");
                User u = new User(Integer.parseInt(userFields[0]), userFields[1], userFields[2]);
                userList.add(u);
                userLine = reader.readLine();
            }
        }

        catch (Exception e) {
                e.printStackTrace();
                System.err.println("An unexpected error occurred");
            } finally {


        }

        for (User u : userList) {
            System.out.println(u);
        }

    }
}
