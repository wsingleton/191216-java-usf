package com.revature;

import com.revature.models.User;

import java.io.*;

public class WriteFileDriver {

    public static void main(String[] args){
        File writeFile = new File("src/resources/users.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))){


            User u = new User(4, "mitch", "passmitch");
            User b = new User(2,"boss", "bosspass");
            User c = new User(50, "boss2", "pass2");
//            writer.write("\n" + u.toFileString());
            writer.write(u.toFileString());
            writer.write(b.toFileString());
            writer.write(c.toFileString());
            System.out.println("Successfully wrote to the file");



        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
