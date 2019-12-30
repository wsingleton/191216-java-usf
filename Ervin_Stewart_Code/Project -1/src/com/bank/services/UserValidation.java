package com.bank.services;

import com.bank.models.Account;
import com.bank.models.User;
import com.bank.ui.UI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation extends UI {
    //public boolean

    public static void isFirstName(String firstname, User myUser){

            if (!firstname.equals(" ") && (firstname !=null) && (firstname.matches("^[a-zA-Z]*$"))) {
            } else createFirstName(firstname, myUser);

    }

    public static void isLastName(String lastname, User myUser){

        if (!lastname.equals(" ") && (lastname !=null) && (lastname.matches("^[a-zA-Z]*$"))) {
        } else createLastName(lastname, myUser);

    }

    public static void isUserName(String username, User myUser){
        int lenght =15;
        if (username.length() <= lenght) {

        } else {
            System.out.println("Username can only be up to 15 characters long. try again.");
            createUserName(username, myUser);
        }
    }

    public static void isPassword(String password, User myUser){
        int maxlength = 14;
        int minlength = 7;

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {

        } else {
            System.out.println("The password must contain special character");
            createPassword(password,myUser);
        }

        if(password.length() <= minlength) {
            System.out.println("password must be at least 8 characters");
            createPassword(password,myUser);}
        else if( password.length() >= maxlength){
            System.out.println("Password can be at most 15 characters, try again");
            createPassword(password,myUser);}
        else {

        }

    }

    public static void validateDeposit(User user, Account account, double deposit){
        if(deposit<0){
            System.out.println("No negative deposits, try again.");
            deposit(user,account);
        } else if(deposit>5000){
            System.out.println("Deposits cannot exceed 5000$");
            deposit(user,account);
        }
    }

    public static void validateWithdrawBalance(User user, Account account, double withdrawal, double balance){
        if(withdrawal> balance || withdrawal <0){
            System.out.println("Invalid withdrawal, try again.");
           withdrawBalance(user,account);
        }
    }

    public static double formatValue(double money){
        BigDecimal bd = new BigDecimal(money).setScale(2, RoundingMode.DOWN);
        double formatedMoney = bd.doubleValue();
        return formatedMoney;
    }
}




