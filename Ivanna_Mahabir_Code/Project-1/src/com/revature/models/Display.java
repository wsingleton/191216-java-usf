package com.revature.models;

import java.util.List;
import java.util.Scanner;

public class Display {

    public static void disPla(List<UserB> disPl, String user) {

        int i = disPl.indexOf(user);
        System.out.println("Welcome Back " + user);
        System.out.println("Select Transaction: Get Balance enter 1, Deposit enter 2, Withdraw enter 3, to Exit enter -1: ");
        Scanner scanner = new Scanner(System.in);

        Integer option = scanner.nextInt(); //if non-int is entered InputMismatchException - needs to handle
        if (option > 4 || option < -2 || option == 0){
            System.out.println("Invalid Entry");
            return;
        } else {

            switch (option) {
                case 1:
                    System.out.println("Your Current Balance: ");
                    System.out.println("Username: " + user + "\nBalance: " + disPl.get(i).getBalance());
                    disPla(disPl, user);
                    break;
                case 2:
                    System.out.println("Enter Deposit Amount greater than 0: ");
                    Double bal = scanner.nextDouble();
                    Double newBal = disPl.get(i).getBalance();
                    if(bal >= 0){
                        newBal += bal;
                        disPl.get(i).setBalance(newBal);
                        System.out.println("New Balance: " + newBal);

                    } else {
                        System.out.println("Invalid Deposit");
                        disPla(disPl, user);
                    }

                    break;

                case 3:
                    System.out.println("Enter Withdrawal Amount greater than 0: ");
                    Double wit = scanner.nextDouble();
                    Double newWit = disPl.get(i).getBalance();
                    if(wit > 0){
                        newWit -= wit;
                        disPl.get(i).setBalance(newWit);
                        System.out.println("New Balance: " + newWit);
                    } else{
                        System.out.println("Invalid Withdrawal");
                        disPla(disPl, user);
                    }

                case -1:
                    System.out.println("Goodbye");
                    return;

                default:
                    System.out.println("Invalid Entry");
                    return;
            }
        }

    }
}
