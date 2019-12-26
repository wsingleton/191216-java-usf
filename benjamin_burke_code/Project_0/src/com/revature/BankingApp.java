package com.revature;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Service service = new Service();


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
//        System.out.println("testing");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = scan.nextLine();

        //username should be checked
        while (true) {
            if(Service.findUser(username) !=null){
                System.out.println("username is taken \nEnter another one");
                username = scan.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Thanks, " + username + "\nWhat's your password?");
        String password = scan.nextLine();

        User u = new User(username, password, 0);
        Service.addUser(u);

        System.out.println("You are signed up! Please sign in.");
        start();
    }
    static void logIn(){
//        System.out.println("testing");
        Scanner scan = new Scanner(System.in);
        System.out.println("Log In\n"
                            + "Enter username"
                            );
        String username = scan.nextLine();
        while(Service.findUser(username)== null) {
            System.out.println("User not found. Try again.");
            username = scan.nextLine();
        }
        System.out.println("Enter password");
        String password = scan.nextLine();
        while(!Service.findUser(username).getPassword().equals(password)){
            System.out.println("Wrong password. Try again.");
            password = scan.nextLine();
        }
        //maybe go back to a log in menu or something?
    }

    static void logInMenu(User u) {
        
    }
}


