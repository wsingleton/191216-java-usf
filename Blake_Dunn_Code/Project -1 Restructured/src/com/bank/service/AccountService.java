package com.bank.service;

import com.bank.ui.RegisterScreen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {

    public static double validateAmount (double input) {

        BigDecimal bigDecimal = BigDecimal.valueOf(input);
        return bigDecimal.setScale(2, RoundingMode.DOWN).doubleValue();

    }

    public static void validateUserName(String input) {
        int l = 15;
        int s = 7;

        if(input.length() <= s) {
            System.out.println("Username is too short. Try again.");
            RegisterScreen.register();
        }
        else if(input.length() >= l) {
            System.out.println("Username is too long. Try again.");
            RegisterScreen.register();
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
            RegisterScreen.register();
        }

        if(input.length() <= s) {
            System.out.println("Password is too short. Try again.");
            RegisterScreen.register();
        }
        else if(input.length() >= l) {
            System.out.println("Password is too long. Try again.");
            RegisterScreen.register();
        }
    }
}
