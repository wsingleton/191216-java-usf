package com.bank.service;

public class UserService {


    public boolean validate(String input) {

        if(!(input.equals(""))) {
            return false;
        }

            return true;
    }
}
