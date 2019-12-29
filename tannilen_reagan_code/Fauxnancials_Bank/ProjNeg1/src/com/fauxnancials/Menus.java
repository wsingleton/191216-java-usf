package com.fauxnancials;

import com.fauxnancials.resources.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    static Boolean valid;
    static int selection=0;
    static Scanner scanner=new Scanner(System.in);
    public static int showLoginScreen() {
        do {
            System.out.println("Are you a new or returning user?");
            System.out.println("1. New");
            System.out.println("2. Existing");
            System.out.println("3. Cancel");
            try {selection = scanner.nextInt();}
            catch(InputMismatchException e) {
                System.out.println("System exception: invalid input.");
                scanner.next();
            }
            if (selection!=1&&selection!=2&&selection!=3) {
                valid=false;
                System.out.println("I'm sorry, I didn't catch that.  Please select 1, 2, or 3.");
                System.out.println("");
            }
            else {valid=true;}
        } while (!valid);
        return selection;
    }
    public static User registerNew(ArrayList<User> knownAccts){
        String username;
        String password;
        ArrayList<String> usernames=new ArrayList<>();
        for (User u : knownAccts) {
            usernames.add(u.getUsername());
        }
        System.out.println("Thank you for choosing Fauxnancials for your banking needs.");
        do {
            System.out.print("Please select a username for this account: ");
            username=scanner.next();
            if (username==null || username=="") {
                System.out.println("I'm sorry, but username may not be blank.");
                valid=false;
            }
            else {
                if (usernames.contains(username)) {
                    System.out.println("I'm sorry, but that username is taken.  Please choose another.");
                    valid=false;
                }
                else {
                    System.out.println("Thank you.  Your username is "+username);
                    valid=true;
                }
            }
        }while (!valid);
        do {
            System.out.println("Passwords must be at least 8 characters in length.");
            System.out.print("Please select a password: ");
            password=scanner.next();
            if (password==null || password==""){
                System.out.println("I'm sorry, but a password is required.");
                valid=false;
            }
            else if (password.length()<8){
                System.out.println("That password is not long enough.  Please try again.");
                valid=false;
            }
            else {
                System.out.println("Please confirm your password.");
                String temp=scanner.next();
                if (!password.equals(temp)) {
                    System.out.println("I'm sorry, but your passwords do not match.");
                    valid=false;
                }
                else {
                    System.out.println("Thank you.  Your password has been set.");
                    System.out.println("For security reasons, please do not share your password.");
                    valid=true;
                }
            }
        }while (!valid);

        User u=new User(username,password);
        return u;
    }
    public static User loginScreen(ArrayList<User> userAccts, String username, String password) {
        int passHash;
        passHash=password.hashCode();
        User u=new User(username,passHash);
        if (userAccts.contains(u)) {
            System.out.println("Valid user ID.");
        }
        else {
            System.out.println("Invalid username or password.");
        }
        return u;
    }
    public static void browseAccount(User current, int balance) {
        System.exit(0);
    }
}
