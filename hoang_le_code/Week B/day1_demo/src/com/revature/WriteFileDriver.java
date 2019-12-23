package com.revature;

import com.revature.model.User;

import java.io.*;

public class WriteFileDriver {
    public static void main(String[] args){
        File writeFile = new File("src/com/revature/resources/users.txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))){

            User u = new User(4, "reaasdas", "dasd");
            writer.write(u.toFileString());



        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
