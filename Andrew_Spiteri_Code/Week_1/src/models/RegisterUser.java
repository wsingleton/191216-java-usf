package models;

import models.Role;
import models.User;

import java.io.*;
import java.lang.System;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class RegisterUser {
    public static User registerUser() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("First name: ");
        String firstname =sc.next();
        System.out.print("Last name: ");
        String lastname =sc.next();
        System.out.print("Username: ");
        String username =sc.next();
        System.out.print("Password: ");
        String password =sc.next();

        Integer newId = new Integer(Objects.hash(username));
        String idString = newId.toString();
        idString = idString.replace('-',' ');
        idString = idString.trim();
        File userFile = new File("resources\\users.txt");
        File accountFile = new File("resources\\accounts.txt");
        try(BufferedWriter userWriter = new BufferedWriter(new FileWriter(userFile,true))){
            User user = new User(idString,firstname, lastname, username, password, "MEMBER");
            userWriter.write(user.toFileString());
            userWriter.flush();
            userWriter.close();
            Account account = new Account(idString,0.0);
            user.setAccount(account);
            BufferedWriter accountWriter = new BufferedWriter(new FileWriter(accountFile,true));
            accountWriter.write(account.toFileString());
            accountWriter.flush();
            accountWriter.close();
            Login.login();
            return user;
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
