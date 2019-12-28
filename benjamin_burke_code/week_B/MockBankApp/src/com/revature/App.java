package com.revature;



import com.revature.models.User;
import resources.UserService;

import java.util.Scanner;

public class App {
    static UserService service = new UserService();
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
        Scanner in = new Scanner(System.in);
        System.out.println("Logging in \n"
                            + "Enter your username: ");
        String username = in.nextLine();
        if(!service.exists(username)) {
            System.out.println("You are not a user. Please try again.");
            logIn();
        } else
        {
            User use = service.getByUsername(username);
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
//        System.out.println("testing the sign up");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        if(service.exists(username)){
            System.out.println("Sorry, the username is taken,");
            signUp();
        } else {
            //validation for username
            System.out.println("Thanks " + username + ". What's your password?");
            String password = scan.nextLine();
            //hmmm idk what to do here thought it'd work
            User user = service.addUser(username, password);
            loggedIn(user);
        }

    }
    static void loggedIn(User u) {
        System.out.println("hello....");
        start();
    }

    static void logOut(){
        System.out.println("goodbye");
    }
}
