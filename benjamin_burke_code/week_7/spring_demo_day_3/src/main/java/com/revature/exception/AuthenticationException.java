package com.revature.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationException extends QuizzardException {

    public AuthenticationException() {
        super("Authentication failed!");
    }

    public AuthenticationException(String message) {
        super(message);
    }

}
