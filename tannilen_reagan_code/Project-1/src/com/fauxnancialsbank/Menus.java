package com.fauxnancialsbank;
import com.fauxnancialsbank.resources.User;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {
    static Scanner scanner=new Scanner(System.in);
    static int selection;
    static boolean valid;
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
        String given;
        String family;
        String pass;
        System.out.println("Thank you for choosing Fauxnancials for your banking needs.");
        do {
            System.out.print("Please select a username for this account: ");
            username=scanner.next();
            if (username==null || username=="") {
                System.out.println("I'm sorry, but username may not be blank.");
                valid=false;
            }
            else {
                if (knownAccts.contains(username)) {
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
            pass=scanner.next();
            if (pass==null || pass==""){
                System.out.println("I'm sorry, but a password is required.");
                valid=false;
            }
            else if (pass.length()<9){
                System.out.println("That password is not long enough.  Please try again.");
                valid=false;
            }
            else {
                System.out.println("Please confirm your password.");
                String temp=scanner.next();
                if (!pass.equals(temp)) {
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
        do {
            System.out.print("Please provide your first (or given) name: ");
            given=scanner.next();
            if (given==null||given=="") {
                System.out.println("I'm sorry, but a name is required.");
                valid=false;
            }
            else {
                System.out.println("Thank you.  Your name has been set to "+given+".");
                System.out.println("Please contact a customer service representative at your local branch office if this is incorrect.");
                valid=true;
            }
        }while (!valid);
        do {
            System.out.print("Please provide your last (or family) name: ");
            family=scanner.next();
            if (family==null||family==""){
                System.out.println("I'm sorry, but a surname is required.");
                valid=false;
            }
            else {
                System.out.println("Thank you.  Your surname has been set to "+family+".");
                System.out.println("Please contact a customer service representative at your local branch office if this is incorrect.");
                valid=true;
            }
        }while(!valid);
        User u=new User(username,given,family,pass);
        return u;
    }
}
