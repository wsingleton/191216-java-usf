package com.revature;

import com.revature.models.User;

import java.io.*;
import java.util.ArrayList;

public class DAO {

    final static String fileLocation = "src/com/revature/Users.txt";

    static {
        File file = new File(fileLocation);
        boolean fileExists = file.exists();
        if(!file.exists()){
            try {
                fileExists = file.createNewFile();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        if(fileExists) System.out.println("The file exists!");
        else System.out.println("no users.txt");
    }

    static void addUser(User u){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))){
            writer.write(u.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> readUsers(){
        ArrayList<User>
    }

    static void syncUsers(ArrayList<User> list){
        cleanup();
        for(User u : list ) {
            addUser(u);
        }
    }

    static void cleanup(){
        try {
            PrintWriter ps = new PrintWriter(fileLocation);
            ps.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
