package com.fauxnancials;

import com.fauxnancials.resources.User;
import com.fauxnancials.services.DocumentationDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InterfaceDriver {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean valid;
        int choice;
        User currentUser;
        int currentUserBalance;
        ArrayList<User> userList = new ArrayList<>(DocumentationDriver.CollectUsers());
        HashMap<String, Integer> accountList=new HashMap<>(DocumentationDriver.CollectAccounts());
        System.out.println("WARNING: Improperly exiting program may cause a loss of data.");
        System.out.println("Always exit the program properly to avoid data loss.");
        System.out.println("");
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
                User newUser = (Menus.registerNew(userList));
                userList.add(newUser);
                accountList.put(newUser.getUsername(),0);
                break;
            }
            case 2: {
                System.out.println("Please enter your username.  Note that usernames are not case sensitive.");
                String user=scanner.next();
                user=user.toLowerCase();
                System.out.println("Please enter your password.  Note that passwords ARE case sensitive.");
                String pass=scanner.next();
                currentUser=Menus.loginScreen(userList,user,pass);
                if (currentUser==null) {
                    System.out.println("Please try again later.");
                    System.exit(0);
                }
                else {
                    currentUserBalance = accountList.get(currentUser.getUsername());
                    Menus.browseAccount(currentUser, currentUserBalance);
                    break;
                }
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
