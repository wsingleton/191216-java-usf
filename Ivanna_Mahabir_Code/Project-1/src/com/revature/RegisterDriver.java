package com.revature;

import com.revature.models.ReadFile;
import com.revature.models.UserB;

// use an array to hold info?? output array separated by :
//Create a temporary object and compare to stored data
// if input is the same as stored data display invalid entry
// import java.lang.reflect.Array;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegisterDriver {

    private UserB myUser;



    public void Register(){
        UserB myUser = new UserB();
        System.out.println("Enter your information to register");
        System.out.println("Username: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
                "\t\t  Must include at least 1 number");
        Scanner scanner = new Scanner(System.in);
        //myUser.setUsername(scanner.nextLine()); //test before set, if invalid reenter
        myUser.validate(scanner.nextLine());
        System.out.println("Password: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
                "\t\t  Must include at least 1 number");
        scanner = new Scanner(System.in);
        myUser.validate(scanner.nextLine());

        // Read file and compare
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

                if(myUser.comparison(userFields[0], userFields[1]) == true){
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
