package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindUserDriver {
    public static void main(String... args){
        System.out.println("please enter your username:");
        Scanner input = new Scanner(System.in);
        String username = input.next();
        System.out.println("please enter your password:");
        String password = input.next();


        File users = new File("src/resources/user.txt");
        List<User> userList = new ArrayList<>();

        try{
            BufferedReader reader  = new BufferedReader(new FileReader(users));
            String userLine = reader.readLine();

            while(userLine != null) {
                String[] userFields = userLine.split(":");
                User u = new User(Integer.parseInt(userFields[0]), userFields[1], userFields[2]);
               userList.add(u);
                userLine = reader.readLine();
                if(u.getPassword().equals(password) && u.getUsername().equals(username)){System.out.println("Successful login!");
                    break;
                }

            }
            System.out.println("Invalid username and password input. \n Try again.");
            main();

        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Unexpected Exception occurred.");}

        for(User u : userList)System.out.println(u);
    }
}


