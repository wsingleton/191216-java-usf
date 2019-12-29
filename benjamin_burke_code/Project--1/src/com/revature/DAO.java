package com.revature;

import com.revature.models.Account;

import java.io.*;
import java.util.ArrayList;

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

    public ArrayList<Account> readAccounts(){
        ArrayList<Account> Accounts = new ArrayList<Account>();
        try(BufferedReader b = new BufferedReader((new FileReader((fileLocation))))){
            String line = null;
            while ((line=b.readLine()) !=null){
                String[] data = line.split(":");
                Account temp = new Account();
                temp.setUsername(data[0]);
                temp.setPassword(data[1]);
                temp.setBalance(Double.parseDouble(data[2]));
                Accounts.add(temp);
            }
        } catch (FileNotFoundException e){
                e.printStackTrace();
        } catch (IOException e){
                e.printStackTrace();
        }
        return Accounts;
    }



}
