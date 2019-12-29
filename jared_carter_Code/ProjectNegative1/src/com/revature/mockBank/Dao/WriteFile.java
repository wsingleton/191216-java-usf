package com.revature.mockBank.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFile {

    public static void main(String[] args) {
        File writeFile = new File("src/Account.txt");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter((writeFile, true)){

            User u = new User (,"","cd", "", "");
            writer.write("\n" + .toFileString());
        } catch (Exception e){
            e.printStackTrace
        }

    }
}
