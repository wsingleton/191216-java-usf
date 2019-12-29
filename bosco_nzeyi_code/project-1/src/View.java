/*
This class act as the main user interface for clients to interact with the program.

Objectives:
- to sign up users;
- to log in;
- view balance;
- deposit;
- withdraw;
- and to see their activity logs.
 */

import java.io.File;
import java.util.Scanner;

public class View {

//    AccountManager record = new AccountManager();
//
//    public void findOperator (String input){
//        input.toLowerCase().trim();
//        String [] fullInput = input.split(" ");
//        String operator = fullInput[0].toLowerCase();
//        String number = fullInput[1];
//        System.out.println(operator);
//
//        switch (operator){
//            case "deposit":
//                int amount = Integer.parseInt(number);
//                record.deposit(amount);
//                break;
//
//            case "withdraw":
//                amount = Integer.parseInt(number);
//                record.withdraw(amount);
//                break;
//
////            case "balance":
////                record.getBalance();
////                break;
////
////            case "activities":
////                record.activityLog();
////                break;
//
//            default:
//                System.out.println(" Please enter the appropriate operator");
//
//        }
//
//
//    }
//
//    public static void main (String [] args){
////        AccountManager manager = new AccountManager();
////        System.out.println("What do you want to do?");
////        Scanner input = new Scanner(System.in);
////        String activity = input.nextLine();
////
////        View task = new View();
////        task.findOperator(activity);
//
//        /*
//        Logical flow of the application
//
//        1) user sign up: action = scanner reader to read user input and transform it to the format of user signup method;
//        2) create a file: call file manager to create a file at the same time while input the user info to the file.
//        3) test the reader.
//         */
//
////        System.out.println("enter your details in the following sequence: " + "\n"
////        + "first name, last name, username, and password"
////        );
////        Scanner userInput = new Scanner(System.in);
////        String fname;
////        String lname;
////        String uname;
////        String pword;
////        fname = userInput.nextLine();
////        System.out.println("lastname");
////        lname = userInput.nextLine();
////        System.out.println("Username");
////        uname = userInput.nextLine();
////        System.out.println("password");
////        pword = userInput.nextLine();
////        System.out.println("you entered " + fname +
////                " " + lname + " " + uname + " " + pword);
//
//        System.out.println("Please wait while the system is creating an account for you");
//        // create the file first.
//                // get the id to complement the user input form console
////        int userId = FileManager.getId();
////
////        String toWrite = userId + "|" + fname + "|" + lname + "|" + uname + "|" + pword;
////            FileManager.writeFile("users.txt", toWrite);
////            System.out.println("Wrote the following to the file: " + "\n" + toWrite);
////        SignUpUsers signup = new SignUpUsers();
////        signup.registerUser(fname, lname, uname, pword);
//
//        /*
//        We will create if statements or switch cases that chose what operation to perform
//        depending on user selection.
//
//        eg.
//        case "signup". Initialize a method for user sign up (signup.registerUser);
//
//        case
//         */
//
//        // test readfile method
//
////        FileManager.readFile("users.txt");
//
//        UserLogIn in = new UserLogIn();
//        in.login("coffee", "passcod");
//        if(in.LoggedId != null){
//            System.out.println("Your id is " + in.LoggedId);
//        } else {
//            System.out.println("Username or password mismatch. Try again!");
//        }
//
////        Scanner userInput = new Scanner(System.in);
//////        String fname;
//////        String lname;
////        String uname;
////        String pword;
//////        fname = userInput.nextLine();
//////        System.out.println("lastname");
//////        lname = userInput.nextLine();
////        System.out.println("Username");
////        uname = userInput.nextLine();
////        System.out.println("password");
////        pword = userInput.nextLine();
////        in.login(uname, pword);
////        System.out.println("We are compiling your data!");
//
//
//
//    }
}
