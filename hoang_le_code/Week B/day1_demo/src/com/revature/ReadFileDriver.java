package com.revature;

import com.revature.model.User;
import com.sun.org.apache.xerces.internal.impl.xs.XSAttributeDecl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDriver {
    public static void main(String[] args){
        File happtText = new File("src/com/revature/resources/readme.txt");
        System.out.println(" does the file exist : " + happtText.exists());
        try{
            BufferedReader reader = new BufferedReader(new FileReader(happtText));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }


        }catch(IOException e){
            System.err.println("exception throw while reading file ");
        }

        catch(Exception e){
            System.err.println("an unexcpected exception occurred");

        }

        System.out.println("-------------------------------");

        File users = new File("src/com/revature/resources/users.txt");
        List<User> userList = new ArrayList<>();


        try{
            BufferedReader reader = new BufferedReader(new FileReader(users));
            String userLine = reader.readLine();
            String[] userFiles= userLine.split(":");
            User u = new User(Integer.parseInt(userFiles[0]), userFiles[1],userFiles[2]);
            userList.add(u);
            userLine = reader.readLine();
        }


        catch(IOException e){
            System.err.println("exception throw while reading file ");
        }

        catch(Exception e){
            System.err.println("an unexcpected exception occurred");

        }
        for(User u : userList) System.out.println(u);

    }
}
