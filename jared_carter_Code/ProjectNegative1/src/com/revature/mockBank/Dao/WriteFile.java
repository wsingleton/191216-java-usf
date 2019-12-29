package com.revature.mockBank.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteFile {

    public static void main(String[] args) {

        try{
            FileWriter fw = new FileWriter("src/com/revature/mockBank/Dao/Account.txt");
            PrintWriter pw = new PrintWriter(fw);
            User u = new User (" ",""," ", " ", 0);

            pw.println();

            pw.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
