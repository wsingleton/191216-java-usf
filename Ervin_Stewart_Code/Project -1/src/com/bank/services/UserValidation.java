package com.bank.services;

import com.bank.models.User;
import com.bank.ui.UI;

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
        int lenght =8;
        if (username.length() <= lenght) {

        } else createUserName(username, myUser);

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

    }}




