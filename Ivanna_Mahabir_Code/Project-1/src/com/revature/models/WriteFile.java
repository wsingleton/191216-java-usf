package com.revature.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {
    public static void writeFil(List<UserB> write){
        File writeFile = new File("src/resources/account.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile))){
            for(UserB y : write) {
                bw.write(y.toFileString()+"\n");
            }

        } catch (Exception e){
            System.out.println("An unexpected error has occurred");
            e.printStackTrace();
        }
    }



}
