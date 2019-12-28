package com.revature;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

    }

    static void start(){
        System.out.println("Welcome to Ben's App!"
                + "\nplease Select an option"
                + "\n1: Log In"
                + "\n2: Sign up");

        Scanner scan = new Scanner(System.in);
        int option = 0;

//        start_loop:
        while(true) {
            try {
                option = Integer.parseInt(scan.nextLine());

                switch(option) {
                    case 1: logIn(); break ;
                    case 2: signUp(); break ;
                    default: System.out.println("Sorry, that's not an option. Please try again");
                }
            }
            catch(NumberFormatException nfe) {
                //nfe.printStackTrace();
                System.out.println("Sorry, that's not an option. Please try again");
            }
        }
    }
}
