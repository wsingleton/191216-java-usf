package com.revature.reimbursement_app.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Authentication failed!");
    }

}
