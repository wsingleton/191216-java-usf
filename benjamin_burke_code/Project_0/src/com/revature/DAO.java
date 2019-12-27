package com.revature;

import com.revature.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DAO {
    //DAO is what we need to drive the functions for the users
    private final static String fileLocation = "src/com/revature/users.txt";

    //Should probably create a users.txt file if not there but we added it manually
    //lets write logic just in case it wouldn't be there
    static {
        File file = new File(fileLocation);
        //to chedck if it does exist
        boolean fileExists = file.exists();
        if(!file.exists()) {
            try {
                fileExists = file.createNewFile();
            } catch (Exception e ) {
                e.getStackTrace();
            }
        }
        if(fileExists) System.out.println("It lives!!!!");
        else System.out.println("it does not live");
         }

         static void addUser(User u){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true)));
         }
}
