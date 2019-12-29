package com.revature;


import com.revature.models.Account;

import java.util.Scanner;

public class App {
    static AccountServices service = new AccountServices();
    public static void main(String[] args) {

        start();
    }

    static  void start(){
        System.out.println("Welcome to the bank app!"
                + "\nPlease log in"
                + "\n1: Log In"
                + "\n2: Register");

        Scanner scan = new Scanner(System.in);
        int op = 0;
        try {
            op=Integer.parseInt(scan.nextLine());

        }
        catch (NumberFormatException nfe){
            System.out.println("Sorry...please pick another number!");
            start();
            scan.close();
            return;
        }
        switch(op) {
            case 1: logIn(); break;
            case 2: signUp(); break;
            default: System.out.println("Sorry, that's not an option. Please try again");
                start();
                scan.close();
                return;
        }
        scan.close();
    }

    static void logIn(){
        System.out.println("test for login");
        Scanner in = new Scanner(System.in);
        System.out.println("Logging in \n"
                + "Enter your username: ");
        String username = in.nextLine();
        if(!service.exists(username)) {
            System.out.println("You are not a user. Please try again.");
            logIn();
        } else
        {
            Account use = service.getByUsername(username);
//            System.out.println(use.toString());
            System.out.println("Enter Password");
            String password = in.nextLine();
            //Lets see if password is valid
            if(use.getPassword().equals(password)) {
                System.out.println("Logged in test");
            }
            else {
                System.out.println("Your password is incorrect try again!");
                logIn();
            }
        }


    }
    static void signUp(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        //need to add an exist method for username
        if(service.exists(username)){
            System.out.println("the username exists");
            signUp();
        } else {
            System.out.println(username + ", Enter a password!");
            String password = scan.nextLine();
            //I will ask the user here if balance should be added
            System.out.println("Would you like to add $ to your account?");
            String deposit = scan.nextLine();
            double balance = 0;
          try {
              balance=Double.parseDouble(deposit);
              if (balance < 2.0){
                  System.out.println("Enter amount greater than $2.00");
                  signUp();
              } else if (balance>100000.00) {
                  System.out.println("Woah there that is too much money!");
              }
          } catch (NumberFormatException nfe) {
              System.out.println("Not a valid amount of money. Try again.");
              signUp();
          }


            Account Account = service.addAccount(username, password, balance);
          //need a login method
          loggedIn(Account);
        }
    }
    //once user successfuly logs in
    static void loggedIn(Account a) {

    }

}
