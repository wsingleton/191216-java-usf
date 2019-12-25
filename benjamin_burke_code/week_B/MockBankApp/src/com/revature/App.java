package com.revature;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
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
                }
        switch(op) {
            case 1: logIn(); break;
            case 2: signUp(); break;
            default: System.out.println("Sorry, that's not an option. Please try again");
                start();
        }
        scan.close();
    }
    static void logIn(){
        Scanner in = new Scanner(System.in);
        System.out.println("Logging in \n"
                            + "Enter your username: ");
        String username = in.nextLine();

    }
    static void signUp(){
        System.out.println("testing the sign up");
    }
}
