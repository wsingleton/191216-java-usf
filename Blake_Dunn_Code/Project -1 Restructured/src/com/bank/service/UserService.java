package com.bank.service;

import com.bank.models.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.bank.ui.MainScreen.display;
import static com.bank.ui.MainScreen.homeScreen;

public class UserService {

    public static int i = 0;

    public static void validateNames(String input) {

        // Using regex to evaluate to check that the string input is only alphabets
        if ((input != null) && (!input.equals("")) && (input.matches("^[a-zA-Z]*$"))) {

        } else {
            System.out.println("Invalid, that is not a name. Try again.");
            homeScreen();
        }
    }

    public static int validateHomeScreenInput() {

        Scanner input = new Scanner(System.in);
        int number = 0;

        try {
            System.out.println("To sign in, press 0");
            System.out.println("To create an account, press 1:  ");
            number = input.nextInt();

            if (number == 0){
                return number;
            }
            else if (number == 1){
                return number;
            }

        }catch (InputMismatchException ime) {
            System.out.println("You must press 0 or 1, try again!");
            homeScreen();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    public static int validateUserInput(Account acct) {

        int number = 0;

        try{
            Scanner input = new Scanner(System.in);

            System.out.println("Check Balance = 0");
            System.out.println("Deposit = 1");
            System.out.println("Withdraw = 2");
            System.out.print("Please choose an option: ");
            number = input.nextInt();

            if (number == 0){
                return number;
            }
            else if(number == 1){
                return number;
            }
            else if(number == 2){
                return number;
            }
            else{
                i++;
                System.out.println(i);
                if (i < 3) {
                    System.out.println("Error: Please try again");
                    System.out.println("");
                    validateUserInput(acct);
                }else if (i == 3) {
                    homeScreen();
                }
            }
        }catch(InputMismatchException ime){
            i++;
            if (i < 3)
            validateUserInput(acct);
            else if (i == 3 )
                homeScreen();
        }
        return number;
    }

    public static void newTransaction(Account acct, Scanner input) {
        int num = 0;
        try{
            num = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");
            // Update balance in account file method
            System.exit(0);
        }
        if(num == 1) {
            display(acct);
        }
        else if (num == 2){
            homeScreen();
        }
        else {
            System.exit(num);
        }
    }
}
