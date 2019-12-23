package com.revature;

import com.revature.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDriver {
    public static void main(String[] args) {
        File rossText = new File("src/resources/readme.txt");
        System.out.println("Does the file exist? :: " + rossText.exists());
        try{
            BufferedReader reader = new BufferedReader(new FileReader(rossText));
            String line = reader.readLine();

            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
            System.err.println("Exception thrown while reading a file.");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An unexpected exception was caught.");
        }
         System.out.println("+--------------------------------------------+");

        File users = new File("src/resources/users.txt");
        List<User> userList = new ArrayList<>();

        //try with resources (introduced in Java 7) :: auto-closes objects declared as resources
        //only allows for the instantiation of objects that implement AutoCloseable interface
        try(BufferedReader reader = new BufferedReader(new FileReader(users))){
            String userLine = reader.readLine();
            while(userLine != null){
                String[] userFields  = userLine.split(":");
                User u = new User(Integer.parseInt(userFields[0]),userFields[1], userFields[2]);
                userList.add(u);
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
