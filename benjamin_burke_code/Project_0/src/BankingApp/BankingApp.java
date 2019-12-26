package BankingApp;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
    start();
    }

    static void start() {
        System.out.println("Welcome to Ben's App!"
                + "\nPlease Sign In or Register"
                + "\n1: Log In"
                + "\n2: Sign In"
        );
        Scanner scan = new Scanner(System.in);
        int option = 0;
        //not sure I need this here I already have the while loop
        try {
            option = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("pick another number");
        }
        // start_loop:
//            while(true) {
//                option = Integer.parseInt(scan.nextLine());
        switch (option) {
            case 1:
                logIn();
                break;
            case 2:
                signUp();
                break;
            default:
                System.out.println("Sorry that is not an option." +
                        "Please try again");
                start();
        }
        scan.close();
    }
    static void signUp(){
        System.out.println("testing");
    }
    static void logIn(){
        System.out.println("testing");
    }
}


