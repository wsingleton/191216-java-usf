package com.revature;


import com.revature.models.User;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

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
                scan.close();
            }

    }
    //create the log in
    static void signUp(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a username!");
        String username = scan.nextLine();

        //validation for the username
        while(true) {
            if(Service.findUser(username) != null){
                System.out.println("sorry, that username is taken, Enter a different one");
                username = scan.nextLine();
            }
            else {
                break;
            }
        }
        System.out.println("What is your password: ");
        String password = scan.nextLine();

        User u = new User(username, password, 0);
        //adduser class
        Service.addUser(u);
    }

    static void logIn(){

    }

}
