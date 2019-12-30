package com.revature.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginDriver {


    public void Login(){
        UserB myLog = new UserB();
        System.out.println("Enter your information to login");
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        myLog.validate(scanner.nextLine());

        System.out.println("Password: ");
        scanner = new Scanner(System.in);
        myLog.validate(scanner.nextLine());

        File acctFile = new File("src/resources/account.txt");
        //System.out.println("Does the file exist? " + acctFile.exists());
        List<UserB> userBList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(acctFile));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] userFields = line.split(":");
                //should be reading file and putting data into list
                userBList.add(i, new UserB(i, userFields[0],userFields[1], Double.parseDouble(userFields[2])));
                //userBList.set() does not work getting IndexOutOfBounds
                //userBList.set(i, (new UserB(i,userFields[0], userFields[1], Double.parseDouble(userFields[2]))));

                if(myLog.comparison(userFields[0], userFields[1]) == true){
                    System.out.println("Already registered");
                    break;
                }
                ++i;


            }
            return;
        }
        catch(Exception e){
            System.out.println("An exception was thrown register");
            e.printStackTrace();
        }
    }
}
