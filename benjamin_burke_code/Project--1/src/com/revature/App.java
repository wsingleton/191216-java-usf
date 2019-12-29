package com.revature;


import com.revature.models.Account;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static AccountServices service = new AccountServices();
    public static void main(String[] args) {

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
        System.out.println("test for login");
        Scanner in = new Scanner(System.in);
        System.out.println("Logging in \n"
                + "Enter your username: ");
        String username = in.nextLine();
        if(!service.exists(username)) {
            System.out.println("You are not a user. Please try again.");
            logIn();
        } else
        {
            Account use = service.getByUsername(username);
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scan.nextLine();
        //need to add an exist method for username
        if(service.exists(username)){
            System.out.println("the username exists");
            signUp();
        } else {
            System.out.println(username + ", Enter a password!");
            String password = scan.nextLine();
            //I will ask the user here if balance should be added
            System.out.println("Would you like to add $ to your account?");
            String deposit = scan.nextLine();
            double balance = 0;
          try {
              balance=Double.parseDouble(deposit);
              if (balance < 2.0){
                  System.out.println("Enter amount greater than $2.00");
                  signUp();
              } else if (balance>100000.00) {
                  System.out.println("Woah there that is too much money!");
              }
          } catch (NumberFormatException nfe) {
              System.out.println("Not a valid amount of money. Try again.");
              signUp();
          }


            Account Account = service.addAccount(username, password, balance);
          //need a login method
          loggedIn(Account);
        }
    }
    //once user successfuly logs in
    static void loggedIn(Account a) {
        //the account information needs to be retrieved
        String username = a.getUsername();
        Double balance = a.getBalance();

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println(" Hello " + username
                            + ", you currently have : $"
                            + decimalFormat.format(balance));

        System.out.println("\n1: Deposit"
                            + "\n2: Withdrawl"
                            + "\n3: Log Out");

        Scanner input = new Scanner(System.in);
        int responst = 0;
        responst = input.nextInt();

        switch (responst){
            case 1: deposit(a); break;
            case 2: withdrawl(a); break;
            case 3: logOut(a); break;
        }
        loggedIn(a);
    }

    private static void deposit(Account a){
        System.out.println("Amount: "+ a.getBalance()
                            + "\nAmount to deposit?" + "\n$");

        Scanner input = new Scanner(System.in);
        double deposit = input.nextDouble();
        double newBelance = a.getBalance() + deposit;
        if (newBelance > 250000.00){
            System.out.println("You reached the 250k limit.");
        } else if (newBelance < a.getBalance()) {
            System.out.println("You can't deposit negative amounts of money, withdrawl");
        } else {
            a.setBalance(newBelance);
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            System.out.println("You deposited $" + deposit + "." + "\n Your new balance is now: $"
                    + decimalFormat.format(a.getBalance()));

            //update the balance
            service.updateBalance(a);
        }

    }

    private static void withdrawl(Account a){
        System.out.println("How much to withdrawl?");

        Scanner input = new Scanner(System.in);

        double withdrawlAmount = input.nextDouble();
        double newBalance = a.getBalance() - withdrawlAmount;
        if(newBalance< 0){
            System.out.println("You don't have money!");
        } else if (newBalance < 2 ) {
            System.out.println("You need to have at least $2 in your account to stay open!");
        } else {
            a.setBalance(newBalance);
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            System.out.println("Amount: " + withdrawlAmount
                                +decimalFormat.format(a.getBalance()) );
            service.updateBalance(a);
        }
    }

    private static void logOut(Account a){
        System.out.println("Logged Out of session");
        service.updateBalance(a);

        start();
    }



}
