package com.revature;

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

    public void ReadFile(String[] file){
        File acctFile = new File("src/resources/account.txt");
        System.out.println("Doest the file exist? " + acctFile.exists());

        List<UserB> userBList = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(acctFile));
            String line = reader.readLine();
            while(line != null){
                file = line.split(":");

          }
        }
        catch(Exception e){
            System.out.println("An exception was thrown");
        }
    }

    public void Register(){
        UserB myUser = new UserB();
        System.out.println("Enter your information to register");
        System.out.println("Username: Must be between 8 to 15 characters in length \n" +
                "\t\t  Must include at least 1 Capital letter \n" +
               // "\t\t  Must include at least 1 common letter \n" +
                "\t\t  Must include at least 1 number");
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        //myUser.setUsername(scanner.nextLine()); //test before set, if invalid reenter
        myUser.validate(scanner.nextLine());
        System.out.println("Password: ");
        scanner = new Scanner(System.in);
        myUser.setPassword(scanner.nextLine()); //test before set if invalid reenter
        //InputMisMatch Exception
        System.out.println("Initial Deposit/Balance: ");
        scanner = new Scanner(System.in);
        myUser.setBalance(scanner.nextDouble());
        

    }

}
