package com.bank.services;

public class UserValidation {
    //public boolean

    public void isFirstName(String firstname){
        boolean continuation = false;
        do {

            if (firstname.equals(" ") || firstname.equals(null)) {
                System.out.println("Invalid input enter a valid first name");
                //continue;

            } else
        }while(!continuation);
    }
}

