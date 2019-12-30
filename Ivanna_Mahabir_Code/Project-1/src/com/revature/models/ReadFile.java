package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private UserB myUser;

    public ReadFile(String[] file){
        File acctFile = new File("src/resources/account.txt");
        System.out.println("Does the file exist? " + acctFile.exists());
        List<UserB> userBList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(acctFile));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] userFields = line.split(":");
                //should be reading file and putting data into list
                userBList.set(i, (new UserB(i, userFields[0], userFields[1], Double.parseDouble(userFields[2]))));
                myUser.comparison(userFields[0], userFields[1]);


                i++;
            }
            return;
        }
        catch(Exception e){
            System.out.println("An exception was thrown here movies");
            e.printStackTrace();
        }
    }
}
