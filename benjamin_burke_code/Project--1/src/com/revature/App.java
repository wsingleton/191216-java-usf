package com.revature;

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
}
