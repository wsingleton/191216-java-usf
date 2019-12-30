package com.bank.service;

import com.bank.models.Account;
import com.bank.ui.RegisterScreen;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bank.ui.MainScreen.display;
import static com.bank.ui.MainScreen.homeScreen;


public class UserService {

    public static void validateNames(String input) {

        // Using regex to evaluate to check that the string input is only alphabets
        if ((input != null) && (!input.equals("")) && (input.matches("^[a-zA-Z]*$"))) {

        } else {
            System.out.println("Invalid, that is not a name. Try again.");
            RegisterScreen.register();
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
            else{
                System.out.println("Error: Please press 0 or 1");
                homeScreen();
            }

        }catch (InputMismatchException ime) {
            System.out.println("You must press 0 or 1, try again!");
            homeScreen();
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
                System.out.println("Error: Please try again");
                System.out.println("");
                display(acct);
            }
        }catch(InputMismatchException ime){
            display(acct);
        }
        return number;
    }
}
