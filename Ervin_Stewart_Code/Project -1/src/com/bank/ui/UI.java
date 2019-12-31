package com.bank.ui;
import com.bank.dao.ReadFromDao;
import com.bank.dao.WriteToTxt;
import com.bank.models.User;
import com.bank.models.Account;
import com.bank.services.UserValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bank.dao.ReadFromDao.*;
import static com.bank.dao.WriteToTxt.replaceBalance;
import static com.bank.services.UserValidation.*;

public class UI extends User {
    private static int UserNumInput;
    private static double UserMoneyInput;
    private static String UserStringInput;
     Scanner input = new Scanner(System.in);

    public static void loginScreen(){
        System.out.println("Welcome!");
        System.out.println("To Login Enter 1");
        System.out.println("To Create An Account Enter 2");
        System.out.println("To Exit The Program Enter 0");
        Scanner input = new Scanner(System.in);
        UserNumInput = input.nextInt();
    switch (UserNumInput){
        case 1:

            accountLoginScreen();

        case 2:
            createUserAccount();

        case 0:
            System.out.println("Program exiting...");

        default:
            System.out.println("Not a valid input");
            loginScreen();


        }
    }


    public static void userConsole(User User, Account Account){
        System.out.println("Welcome, " +User.getFirstName() +"!");
        System.out.println("To view balance enter 1\n" +
                "To make a deposit enter 2\n" +
                "To make a withdrawal enter 3");
        System.out.println("To exit enter 0");
       // System.out.println(Account);
        //System.out.println(User);
        Scanner input = new Scanner(System.in);
        UserNumInput = input.nextInt();
        switch (UserNumInput){
            case 1:
                viewBalance(User,Account);
            case 2:
                //System.out.println("User can make a deposit");
                deposit(User,Account);

            case 3:
                //System.out.println("You can now make a withdrawal");
                withdrawBalance(User, Account);
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

        System.out.println("Please Login.");
        //System.out.println(currentAccount);
        String username = enterUsername();
       currentUser= enterPassword( username);
      // System.out.println(currentAccount);
       currentAccount = getUserAccount(currentUser);
      //  System.out.println(currentAccount);
        userConsole(currentUser, currentAccount);

    }

    public static void createUserAccount(){
        System.out.println("Please create an account.");
        User newUser = new User();
        Account newUserAccount = new Account();
        createFirstName(UserStringInput, newUser);
        createLastName(UserStringInput, newUser);
        createUserName(UserStringInput,newUser);
        createPassword(UserStringInput,newUser);
        generateId(newUser);
        newUserAccount.setAccountId(newUser.getId());
        WriteToTxt.writeUserToFile(newUser);
        WriteToTxt.writeAccountToFile(newUserAccount);
        //System.out.println("the user Details are as follows: \n" + newUser +"\n"+ newUserAccount.toFileString());
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
        ReadFromDao.isUsernameTaken(UserStringInput,newUser);
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

    public static User enterPassword(String userstringinput){
    Scanner input = new Scanner(System.in);
    User currentUser = new User();
   System.out.println("Please enter your password");
   UserStringInput = input.next();
   currentUser = isUser(UserStringInput, userstringinput);
   return currentUser;
}

    public static String enterUsername() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username");
        UserStringInput = input.next();
        return UserStringInput;
    }

    public static void deposit(User User, Account Account){
        double deposit = 0;
        double newbalance;
        double currentbalance;
        System.out.println("How much would you like to deposit today " +User.getFirstName()+"?");
        Scanner input = new Scanner(System.in);

        try{UserMoneyInput = input.nextDouble();
        deposit = UserMoneyInput;}
        catch(InputMismatchException e){
            System.out.println("Must be a number");
            deposit(User,Account);
        }catch(Exception j){}
        validateDeposit(User,Account,deposit);
        currentbalance = Account.getBalance();
        String oldID = Integer.toString(Account.getAccountId());
        String newID = Integer.toString(Account.getAccountId());
        String oldbalance = Double.toString(currentbalance);
        newbalance = deposit + currentbalance;
     //   Account.setBalance(newbalance);
        newbalance =formatValue(newbalance);
        String currentBalance = Double.toString(newbalance);
        System.out.println("The new balance is:\n" + newbalance);
        //System.out.println(oldID);
        //System.out.println(oldbalance);
        //System.out.println(newID);
        //System.out.println(currentBalance);
        Account.setBalance(newbalance);
        replaceBalance(oldID, oldbalance,newID,currentBalance);
        System.out.println("Press 1 to return to the main console");

        System.out.println("Press 0 to exit");
        UserNumInput = input.nextInt();
        switch (UserNumInput){


            case 0:
                System.out.println("Program exiting...");
                System.exit(0);
            case 1:
                userConsole(User, Account);
            default:
                System.out.println("Not a valid input");
    }
    }


    public static void viewBalance(User User, Account Account){
        double balance=0;
       // System.out.println(Account);
        System.out.println("The balance is: \n" + getUserAccountBalance(User));
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to return to the main console");

        System.out.println("Press 0 to exit");
        UserNumInput = input.nextInt();
        switch (UserNumInput){


            case 0:
                System.out.println("Program exiting...");
                System.exit(0);
            case 1:
                userConsole(User, Account);
            default:
                System.out.println("Not a valid input");



        }

    }

    public static void withdrawBalance(User user, Account account){
        System.out.println("The balance is: \n" + account.getBalance());
       // System.out.println(account);
        System.out.println("How much would you like to withdraw today?");
        Scanner input = new Scanner(System.in);

        double withdrawal = 0;
        double newbalance;
        double currentbalance;

        try{
            UserMoneyInput = input.nextDouble();
            withdrawal = UserMoneyInput;}

        catch(InputMismatchException e){
            System.out.println("Must be a number");
            withdrawBalance(user,account);
        }catch(Exception j){}
        currentbalance = account.getBalance();
        validateWithdrawBalance(user, account, withdrawal, currentbalance);
        newbalance =  currentbalance - withdrawal;
        String oldID = Integer.toString(account.getAccountId());
        String newID = Integer.toString(account.getAccountId());
        String oldbalance = Double.toString(currentbalance);
        newbalance=formatValue(newbalance);
        String currentBalance = Double.toString(newbalance);

        account.setBalance(newbalance);
        System.out.println("The new balance is:\n" + newbalance);
        replaceBalance(oldID, oldbalance,newID,currentBalance);
        System.out.println("Press 1 to return to the main console");

        System.out.println("Press 0 to exit");
        UserNumInput = input.nextInt();
        switch (UserNumInput){


            case 0:
                System.out.println("Program exiting...");
                System.exit(0);
            case 1:
                userConsole(user, account);
            default:
                System.out.println("Not a valid input");
    }
    }
}

