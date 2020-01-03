package com.revature.models;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.revature.models.WriteFile.writeFil;

public class Display {


    public static void disPla(List<UserB> disPl, String user) {
        try {
            double mon = 0;
            int dex = 0;
            for(UserB u : disPl){if(u.getUsername().equals(user)) {
                mon = u.getBalance();
                dex = disPl.indexOf(u);
                 }
            }

            System.out.println("Welcome Back " + user);
            System.out.println("Select Transaction: Get Balance enter 1, Deposit enter 2, Withdraw enter 3, to Exit enter -1: ");
            Scanner scanner = new Scanner(System.in);

            Integer option = scanner.nextInt();
            if (option > 4 || option < -2 || option == 0) {
                System.out.println("Invalid Entry");
                return;
            } else {

                switch (option) {
                    case 1:
                        System.out.println("Your Current Balance: ");
                        System.out.println("Username: " + user + "\nBalance: " + mon + "\n");
                        disPla(disPl, user);
                        break;
                    case 2:
                        System.out.println("Enter Deposit Amount greater than 0: ");
                        Double bal = scanner.nextDouble();
                        System.out.println("Current Balance: " + mon);
                        if (bal >= 0) {
                            mon += bal;
                            disPl.get(dex).setBalance(mon);

                           /// write deposit to file
                            System.out.println("New Balance: " + mon);
                            writeFil(disPl);
                            disPla(disPl, user);
                            System.out.println("\n\n");

                        } else {
                            System.out.println("Invalid Deposit");
                            disPla(disPl, user);
                        }

                        break;

                    case 3:
                        System.out.println("Current Balance: " + mon);
                        System.out.println("\nEnter Withdrawal Amount greater than 0: ");
                        Double wit = scanner.nextDouble();
                        Double newWit = disPl.get(dex).getBalance();
                        if (wit > -1 && wit <= newWit ) {
                            newWit -= wit;
                            disPl.get(dex).setBalance(newWit);
                            System.out.println("New Balance: " + newWit);
                            writeFil(disPl);
                            disPla(disPl, user);
                            System.out.println("\n\n");

                        } else {
                            System.out.println("Invalid Withdrawal");
                            disPla(disPl, user);
                        }
                        break;

                    case -1:
                        break;
                       // return to main menu;

                    default:
                        System.out.println("Invalid Entry");
                        return;
                }
            }

        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input");

            e.printStackTrace();
            return;
        }
    }


}
