package com.revature.exceptions;

import com.revature.BankMain;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        System.out.println("The combination of username and/or password is incorrect");
        BankMain.navigation.navigate("/home");
    }
}
