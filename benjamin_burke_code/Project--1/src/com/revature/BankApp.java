package com.revature;


import com.revature.models.User;


import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        //create a service object to run services
        Service service = new Service();
        //grab the users to read the text file while printing it out
        service.users = DAO.readAllUsers();
        printAll(service.users);
        //allows for the main menu to appear
        start();
    }
    //to print the list
    private static void printAll(ArrayList<User> list) {
        for(User u : list){
            System.out.println(u.toString());
        }
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
//        scan.close();
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
        System.out.println("Signed up, returning to menu");
        start();
    }

    static void logIn(){
//        System.out.println("testing the Login");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        System.out.println(username);
        System.out.println(Service.findUser(username));
        while(Service.findUser(username)==null){
            System.out.println("not a user.");
            username = scan.nextLine();
        }
        System.out.println("Enter password");
        String password = scan.nextLine();
        while(!Service.findUser(username).getPassword().equals(password)){
            System.out.println("wrong password. try again.");
            password = scan.nextLine();
        }

    }

    static void printLogInMenu(){
        System.out.println("Logged in!"
                            + "\n1: Balance"
                            + "\n2: Deposit"
                            + "\n3: Withdraw"
                            + "\n4: Log Out");
    }

}
