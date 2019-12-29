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

import accounting.AccountManager;
import accounting.RecordKeeper;
import users.SignUpUsers;
import users.UserLogIn;

import java.util.Scanner;

public class View {

    // importing methods
    public static AccountManager account = new AccountManager();
    public static UserLogIn login = new UserLogIn();
    public static RecordKeeper records = new RecordKeeper();

    // class static instances
    public static int userId;
    public static String userChoice = null;

    // class method
    public static void options(String choices){ // this works only if userId is not null. to be tested first.
        switch (choices){
            case "1": // deposit
                account.transaction(userId, "deposit");
                break;

            case "2": // withdraw
                account.transaction(userId, "withdraw");
                break;

            case "3": // get balance
                account.getBalance(userId);
                break;

            case "4": // log transaction history
                records.getRecord(new Integer(userId).toString());
                break;

            case "5":
                System.out.println("Invalid option. Try again please. Thank you for banking with us.");

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }


    public static void main (String ... args){

        // global vars for user option
        String input = null;
        String username = null;
        String password = null;

        // New user? register. Registered user? login
        System.out.println("Welcome to MockBank!" + "\n" +
                "Press 1 to create an account (for new users only" + "\n" +
                "Press 2 to log in (for existing users only)");
        Scanner reader = new Scanner(System.in);
        input = reader.nextLine();
        if(input.equals("1") || input.equals("2")){
            switch (input){
                case "1":
                    SignUpUsers register = new SignUpUsers();
                    register.getInput();
                    System.out.println("Enter 1 to continue with login in");
                    String option = reader.nextLine();
                    if(option.equals("1")){
                        System.out.println("Enter username");
                        username = reader.nextLine();
                        System.out.println("Enter password");
                        password = reader.nextLine();
                        login.login(username, password);
                        userId = new Integer(login.LoggedId);
                        if(!new Integer(userId).equals(null)){
                            System.out.println("Chose one of the options below to continue: " + "\n" +
                                    "1 = Deposit," + "\n" + "2 = Withdraw, " + "\n" + "3 = Check balance," + "\n" +
                                    "4 = View account history, " + "\n" + "5 = exit");
                            String choice = reader.nextLine();
                            options(choice);
                        } else {
                            System.out.println("An error occurred while detecting user. Please try again");
                        }
                    } else {
                        System.out.println("Invalid option. Try again");
                    }
                    break;
                case "2":
                    System.out.println("Enter username");
                    username = reader.nextLine();
                    System.out.println("Enter password");
                    password = reader.nextLine();
                    login.login(username, password);
                    userId = new Integer(login.LoggedId);

                    // log options when the user id is detected.
                    if(!new Integer(userId).equals(null)){
                        System.out.println("Chose one of the options below to continue: " + "\n" +
                                "1 = Deposit," + "\n" + "2 = Withdraw, " + "\n" + "3 = Check balance," + "\n" +
                                "4 = View account history, " + "\n" + "5 = exit");
                        String choice = reader.nextLine();
                        options(choice);
                    } else {
                        System.out.println("An error occurred while detecting user. Please try again");
                    }
                    break;

                default:
                    System.out.println("No selection made. Please try again!");
            }
        } else{
            System.out.println("Wrong selection. Try again!");
        }
    }
}
