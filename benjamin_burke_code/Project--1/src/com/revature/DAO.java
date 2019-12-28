package com.revature;

import com.revature.models.Account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DAO {

    final static String fileLocation ="src/com/revature/Accounts.txt";

    void addAccount(Account a){
        //must write the account user to the text file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))){
            writer.write(a.toString());
        } catch (IOException e){
            e.printStackTrace();

        }
    }

}
