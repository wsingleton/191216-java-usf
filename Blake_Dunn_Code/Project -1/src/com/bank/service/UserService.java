package com.bank.service;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bank.ui.UserScreen.register;

public class UserService {

    public static void validateNames(String input) {

        // Using regex to evaluate to check that the string input is only alphabets
        if ((input != null) && (!input.equals("")) && (input.matches("^[a-zA-Z]*$")) == true) {

        } else {
            System.out.println("Invalid, that is not a name. Try again.");
            register();
        }
    }

    public static void validateUserName(String input) {
        int l = 15;
        int s = 7;

        if(input.length() <= s) {
            System.out.println("Username is too short. Try again.");
            register();
        }
        else if(input.length() >= l) {
            System.out.println("Username is too long. Try again.");
            register();
        }
        else {
        }

    }

    public static void validatePassword(String input) {
        int l = 15;
        int s = 7;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
        }
        else {
            System.out.println("Please include a special character.");
            register();
        }

        if(input.length() <= s) {
            System.out.println("Password is too short. Try again.");
            register();
        }
        else if(input.length() >= l) {
            System.out.println("Password is too long. Try again.");
            register();
        }
        else {
        }
    }
}

