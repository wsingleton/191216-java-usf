package com.bank.services;

public class UserValidation {

    public static void isEmail(String email){
        boolean continuation = false;
        do {

            if (email.contains("@")) {
                continuation = true;
                //continue;

            } else System.out.println("invalid email");
        }while(!continuation);
    }
}

