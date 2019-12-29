package com.revature.mockBank.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("src/com/revature/mockBank/Dao/Account.txt");
            BufferedReader br = new BufferedReader(fr);

            String s;
            while ((str = br.readLine()) != null){
                out.println(s + "\n");
            }

        }

    }




}
