package com.bank.dao;

import com.bank.models.Account;
import com.bank.models.User;

import java.io.*;

public class WriteToTxt {

    public static void writeUserToFile( User user) {
        File writeFile = new File("src/resources/user.txt");

        // try-with-resources (introduced in java 7) :: auto-closes objects declared as
        // resources only allows for the instantiation of objects that implement auto-closeable interface
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile,true))){

            writer.write("\n"+ user.toFileString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void writeAccountToFile( Account account) {
        File writeFile = new File("src/resources/account.txt");

        // try-with-resources (introduced in java 7) :: auto-closes objects declared as
        // resources only allows for the instantiation of objects that implement auto-closeable interface
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile,true))){

            writer.write("\n"+ account.toFileString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void replaceBalance(String prevAccountNum,String prevAccountBal,String newAccountNum, String newAccountBal){
        File accounts = new File("src/resources/account.txt");
        String content ="\n";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(accounts));
            String line = reader.readLine();
            while(line != null){
                line = reader.readLine();
               content += line +"\n";


//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts))){
//                String modifier = content.replaceAll(prevAccountNum+":"+prevAccountBal,newAccountNum+":"+newAccountBal ).replaceAll("null","");
//                writer.write(modifier);

            }}catch (Exception e){
//                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(accounts))){
                String modifier = content.replaceAll(prevAccountNum+":"+prevAccountBal,newAccountNum+":"+newAccountBal ).replaceAll("null","");
                writer.write(modifier);
               // System.out.println(prevAccountNum);
                //System.out.println(prevAccountBal);
               // System.out.println(newAccountNum);
               // System.out.println(newAccountBal);
        }catch (NullPointerException np1){

        }catch(IOException ioe){
            System.out.println("Exception thrown while reading file.");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
