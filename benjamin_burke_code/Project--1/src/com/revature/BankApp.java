package com.revature;


import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Service service = new Service();

        start();
    }
    static void start(){
        System.out.println("Welcome to Bens Banking App!"
                            + "\nPlease log in or register"
                            + "\n: Log In"
                            + "\n: Sign Up");
        Scanner scan = new Scanner(System.in);
        //we need to do a switch statement for user input
        int option =0;

            while(true){
                try{

                    option = Integer.parseInt(scan.nextLine());

                    switch (option){
                        case 1: logIn(); break;
                        case 2: signUp(); break;
                    }
                }
                catch (NumberFormatException nfe){
                    System.out.println("That is not an option");
                }
            }
            scan.close();
    }
    //create the log in
    static void signUp(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a username!");
        String username = scan.nextLine();

        //validation for the username
        while(true) {

        }
    }
}
