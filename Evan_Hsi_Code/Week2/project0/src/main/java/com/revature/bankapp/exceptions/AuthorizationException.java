package com.revature.bankapp.exceptions;

public class AuthorizationException extends RuntimeException {
    AuthorizationException() {
        super("Not Authorized");
    }
}
