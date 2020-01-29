package com.revature.reimbursement_app.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("You do not have the proper permissions to perform that action!");
    }

}
