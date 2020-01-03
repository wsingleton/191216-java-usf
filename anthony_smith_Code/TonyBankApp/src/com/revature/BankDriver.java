package com.revature;

import com.revature.User;
import com.revature.Bank;
import java.util.HashMap;
import java.util.Scanner;

public class BankDriver {


    public static void main(String[] args) {

        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\tWelcome to Tony's Bank Application\n\n");

        System.out.println("\tPlease make a selection\n");

        System.out.println("1.\t Login ");
        System.out.println("2.\t Create a new account");
        System.out.println("3.\t Exit");

        String choice = "";
        boolean success = false;
        while (!success) {
            System.out.println();
            try {
                choice = scanner.next();
            } catch (Exception e) {
                System.out.println("not an string");
            }
            success = true;

            switch (choice.toLowerCase()) {
                case "1":
                    bank.login();
                    break;
                case "2":
                    bank.createNewUser();
                    break;
                case "3":
                    System.exit(0);
                    WriteToFile wtf = new WriteToFile();
                    wtf.writeMap(bank.userDb);
                    break;
                default:
                    success = false;
                    System.out.println("You selected an invalid selection. Please try again");
                    break;
            }

            WriteToFile wtf = new WriteToFile();
            wtf.writeMap(bank.userDb);
        }
    }
}
