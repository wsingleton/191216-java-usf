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
            balance=Double.parseDouble(deposit);
            if (balance < 2.0){
                System.out.println("Enter amount greater than $2.00");
                signUp();
            } else if (balance>100000.00) {
                System.out.println("Woah there that is too much money!");
            }
            //get an error
            Account account = service.addAccount(username, password, balance);
        }
    }
}
