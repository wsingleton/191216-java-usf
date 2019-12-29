
package com.revature;


import com.revature.models.User;


import java.io.*;


public class WriteFileDriver {


    public static void main(String[] args) {

        File writeFile = new File("src/resources/users.txt");

        // try-with-resources (introduced in Java 7) :: auto-closes objects declared as resources

        // only allows for the instantiation of objects that implement AutoCloseable interface

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile, true))) {

            User u = new User(4, "rconnell", "java");

            writer.write("\n" + u.toFileString());

        } catch (Exception e) {

            e.printStackTrace();

        }



    }







}