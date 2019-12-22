package com.bank.ui;
import com.bank.models.User;
import com.bank.models.Account;
import com.bank.services.UserValidation;

import java.util.Scanner;

public class UI extends User {
    private static int UserNumInput;
    private static double UserMoneyInput;
    private static String UserStringInput;
     Scanner input = new Scanner(System.in);

    public static void loginScreen(){
        System.out.println("Welcome!");
        System.out.println("To Login Enter 1");
        System.out.println("To Create An Account Enter 2");
        System.out.println("To Exit The Program Enter 2");
        Scanner input = new Scanner(System.in);
        UserNumInput = input.nextInt();
    switch (UserNumInput){
        case 1:
           // System.out.println("User Can now login");
            accountLoginScreen();

        case 2:
            //System.out.println("User can create a login");
            //loginScreen();
            createUserAccount();

        case 0:
            System.out.println("Program exiting...");

        default:
            System.out.println("Not a valid input");
            loginScreen();


        }
    }






    public static void userConsole(User User, Account Account){
        System.out.println("Welcome!");
        System.out.println("To view balance, make a deposit or make a withdrawal enter 1");
        System.out.println("To exit enter 0");
        Scanner input = new Scanner(System.in);
        UserNumInput = input.nextInt();
        switch (UserNumInput){
            case 1:
                System.out.println("User Can now view");
                viewBalance(User,Account);

            case 0:
                System.out.println("Program exiting...");
               System.exit(0);
            default:
                System.out.println("Not a valid input");




        }
    }


    public static void accountLoginScreen(){
    User currentUser = new User();
    Account currentAccount = new Account();

        System.out.println("Please Login");
        enterUsername();
        enterPassword();
        userConsole();

    }

    public static void createUserAccount(){
        System.out.println("Please create An Account ");
        User newUser = new User();
        Account newUserAccount = new Account();
        //Scanner input = new Scanner(System.in);

       // UserStringInput = input.next();
        createFirstName(UserStringInput, newUser);
        createLastName(UserStringInput, newUser);
        createUserName(UserStringInput,newUser);
        createPassword(UserStringInput,newUser);
        generateId(newUser);
        Account.setId(newUser.getId());

        System.out.println("the user Details are as follows \n" + newUser +"\n"+ newUserAccount);
        userConsole(newUser,newUserAccount);

    }


    public static void createLastName(String myinput, User newUser) {
        System.out.println("Please enter your lastname");
        Scanner input = new Scanner(System.in);
        UserStringInput = input.next();
        UserValidation.isLastName(UserStringInput, newUser);
        newUser.setLastName(UserStringInput);
    }

    public static void createFirstName(String myinput, User newUser) {
        System.out.println("Please enter your firstname");
        Scanner input = new Scanner(System.in);

        UserStringInput = input.next();
        UserValidation.isFirstName(UserStringInput, newUser);
        newUser.setFirstName(UserStringInput);
    }


    public static void createUserName(String myinput, User newUser){
        System.out.println("Please create your username:");
        Scanner input = new Scanner(System.in);
        UserStringInput = input.next();
        UserValidation.isUserName(UserStringInput, newUser);
        newUser.setUserName(UserStringInput);

    }


    public static void createPassword(String myinput, User newUser){

        System.out.println("Please create your password");
        Scanner input = new Scanner(System.in);

        UserStringInput = input.next();
        UserValidation.isPassword(UserStringInput, newUser);
        newUser.setPassword(UserStringInput);

    }

    public static void enterPassword(){
    Scanner input = new Scanner(System.in);
   System.out.println("Please enter your password");
   UserStringInput = input.next();
   //comparePassword(UserStringInput);
}

    public static String enterUsername() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username");
        UserStringInput = input.next();
        //comparePassword(UserStringInput);
        return ;
    }

    public static void deposit(User User, Account Account){
        double deposit=0;
        double newbalance;
        double currentbalance;
        System.out.println("How much money in yo pocket homie?");
        Scanner input = new Scanner(System.in);
        UserMoneyInput = input.nextDouble();
        deposit = UserNumInput;
        //validDeposit(deposit);
        currentbalance = Account.getBalance();
        newbalance = deposit + currentbalance;
        Account.setBalance(newbalance);
        System.out.println("The new balance is:\n" + Account.getBalance());
        viewBalance(User,Account);
    }

    public static void viewBalance(User User, Account Account){
        double balance=0;
        System.out.println("The balance is: \n" + Account.getBalance());
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to make a deposit");
        System.out.println("Press 2 to make a withdrawal");
        System.out.println("Press 0 to exit");
        UserNumInput = input.nextInt();
        switch (UserNumInput){

            case 1:
                System.out.println("User can make a deposit");
                deposit(User,Account);

            case 2:
                System.out.println("You can now make a withdrawal");
                //withdrawBalance(User, Account);
            case 0:
                System.out.println("Program exiting...");
                System.exit(0);
            default:
                System.out.println("Not a valid input");



        }

    }
}

