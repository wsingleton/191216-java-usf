package com.fauxnancialsbank;
import com.fauxnancialsbank.resources.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIMain {
    public static void main(String[] args){
        //variables
        Scanner scanner=new Scanner(System.in);
        boolean valid;
        int choice;
        ArrayList<User> usersList = new ArrayList<>();
        File users=new File("src/resources/users.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(users))){
            String userLine=reader.readLine();
            while (userLine!=null) {
                String[] userFields = userLine.split(",");
                User u = new User(userFields[0],userFields[1],userFields[2],userFields[3],Integer.parseInt(userFields[4]));
                usersList.add(u);
                userLine=reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("There has been a critical exception with the system database.");
            System.out.println("We apologize for the inconvenience.  Please try again later.");
            System.exit(0);
        }
        do {
            System.out.print("Are you using a screen reader (y/n)? ");
            String ans=scanner.next();
            char first=ans.charAt(0);
            first=Character.toLowerCase(first);
            if (first=='y') {
                valid=true;
                showPlainTextGreeting();
            }
            else if (first=='n') {
                valid=true;
                showASCIIGreeting();
            }
            else {
                valid=false;
                System.out.println("I didn't catch that.  Please answer y or n.");
            }
        } while (!valid);
        choice=Menus.showLoginScreen();
        switch (choice) {
            case 1: {
                User newUser = (Menus.registerNew(usersList));
                usersList.add(newUser);
                break;
            }
            case 2: {
                System.out.println("This will lead to the login screen.");
                break;
            }
            case 3: {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }

    }
    public static void showPlainTextGreeting() {
        System.out.println("Welcome to Fauxnancials Bank!");
        System.out.println("");
    }
    public static void showASCIIGreeting() {
        System.out.println("#######                                                                            ######                       ");
        System.out.println("#         ##   #    # #    # #    #   ##   #    #  ####  #   ##   #       ####     #     #   ##   #    # #    # ");
        System.out.println("#        #  #  #    #  #  #  ##   #  #  #  ##   # #    # #  #  #  #      #         #     #  #  #  ##   # #   #  ");
        System.out.println("#####   #    # #    #   ##   # #  # #    # # #  # #      # #    # #       ####     ######  #    # # #  # ####   ");
        System.out.println("#       ###### #    #   ##   #  # # ###### #  # # #      # ###### #           #    #     # ###### #  # # #  #   ");
        System.out.println("#       #    # #    #  #  #  #   ## #    # #   ## #    # # #    # #      #    #    #     # #    # #   ## #   #  ");
        System.out.println("#       #    #  ####  #    # #    # #    # #    #  ####  # #    # ######  ####     ######  #    # #    # #    # ");
        System.out.println("");
    }
}
