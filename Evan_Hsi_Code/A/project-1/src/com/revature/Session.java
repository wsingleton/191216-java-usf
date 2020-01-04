package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Session {

    public static void main(String[] args) {
        int userId = 0;
        String userName = "";
        String password = "";
        String userBasePath = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/userBase.txt";
        String acctBasePath = "/Users/evanhsi/Documents/repos/191216-java-usf/Evan_Hsi_Code/A/project-1/acctBase.txt";

        Bank bank = new Bank();
        File userBaseFile = new File(userBasePath);
        File acctBaseFile = new File(acctBasePath);
        Scanner userBaseScanner = null;
        Scanner acctBaseScanner = null;

        try {
            userBaseScanner = new Scanner(userBaseFile);
            while(userBaseScanner.hasNext()) {
                bank.makeUser(userBaseScanner, true);
            }
        }
        catch (FileNotFoundException fnf) {System.out.println(fnf.getMessage()); }
        catch (IOException io) { System.out.println(io.getMessage()); }
        catch (Exception e) { System.err.println("Unexpected exception occurred"); }

        try {
            acctBaseScanner = new Scanner(acctBaseFile);
            while(acctBaseScanner.hasNext()) {
                bank.makeAcct(acctBaseScanner, new User(), true);
            }

        }
        catch (FileNotFoundException fnf) {System.out.println(fnf.getMessage()); }
        catch (IOException io) { System.out.println(io.getMessage()); }
        catch (Exception e) { System.err.println("Unexpected exception occurred"); }

        //bank.printAllUsers();
        //bank.printAllAccounts();

        Scanner interactive = new Scanner(new InputStreamReader(System.in));

        boolean success = false;
        while(!success) {
            //bank.printAllUsers();
            System.out.println("Enter: \n0 to register a new user\n1 to log in");
            int mode = interactive.nextInt();
            switch (mode) {
                case 0:
                    int id = bank.makeUser(interactive, false);
                    if( id != -1) {
                        success = true;
                        id = userId;
                    }
                    break;
                case 1:
                    System.out.println("Enter username: ");
                    userName = interactive.next();
                    userId = Objects.hash(userName);
                    if(bank.userContains(userName)) {
                        System.out.println("Enter password: ");
                        password = interactive.next();
                        if(password.equals(bank.userAt(userId).getPassword())) {
                            success = true;
                            System.out.println("Login Successful\nWelcome " + bank.userAt(userId).getFirstName() +
                                    " " + bank.userAt((userId)).getLastName());
                        }
                        else { System.out.println("Invalid Password"); break; }
                    }
                    else { System.out.println("User does not exist"); break; }
                    break;
                default:
                    break;
            }
        }
        boolean exit = false;
        String operation = "";
        while(!exit) {
            bank.listAccounts(userId);
            System.out.println("Enter:\nDeposit to deposit into an account\nWithdraw to make a withdrawal\n" +
                    "Create to make new account\nExit to log off");
            operation = interactive.next();
            switch(operation.toLowerCase()) {
                case "deposit":
                    if(bank.userAt(userId).getAccountsLength() != 0) {
                        System.out.println("Enter the index of the account into which you want to make a deposit:");
                        int index = 0;
                        try { index = interactive.nextInt(); }
                        catch (InputMismatchException ime) {
                            System.out.println("Not a valid Index");
                            break;
                        }
                        if(index < bank.userAt(userId).getAccountsLength() && index >= 0) {
                            System.out.println("Enter the amount you would like to deposit:");
                            double amount = 0;
                            try { amount = interactive.nextDouble(); }
                            catch (InputMismatchException ime) {
                                System.out.println("Not a number");
                                break;
                            }
                            bank.makeDeposit(bank.userAt(userId).getAccount(index).getActId(), amount);
                        }
                        else System.out.println("Account does not exist.");
                    }
                    else
                        System.out.println("You do not have any accounts.");
                    break;
                case "withdraw":
                    if(bank.userAt(userId).getAccountsLength() != 0) {
                        System.out.println("Enter the index of the account from which you want to withdraw");
                        int indexWithdraw = 0;
                        try { indexWithdraw = interactive.nextInt(); }
                        catch (InputMismatchException ime) {
                            System.out.println("Not a valid Index");
                            break;
                        }
                        if(indexWithdraw < bank.userAt(userId).getAccountsLength() && indexWithdraw >= 0) {
                            System.out.println("Enter the amount you would like to withdraw");
                            double amountWithdraw;
                            try { amountWithdraw = interactive.nextDouble(); }
                            catch (InputMismatchException ime) {
                                System.out.println("Not a number");
                                break;
                            }
                            bank.makeWithdrawal(bank.userAt(userId).getAccount(indexWithdraw).getActId(), amountWithdraw);
                        }
                        else System.out.println("Account does not exist.");
                    }
                    else
                        System.out.println("You do not have any accounts.");
                    break;
                case "create":
                    bank.makeAcct(interactive, bank.userAt(userId), false);
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Logging off");
                    break;
                default:
                    break;
            }
        }
        bank.serializeUser();
        bank.serializeAcct();
    }
}
