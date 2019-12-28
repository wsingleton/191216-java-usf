package com.revature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {

    final static String fileLocation = "src/com/revature/Users.txt";

    void addUser(User u){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))){
            writer.write(u.toString());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> readUsers(){
        ArrayList<User> Users = new ArrayList<User>();
        try (){

        } catch () {

        } catch (){

        }
        return Users;
    }


}

