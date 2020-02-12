package com.revature.exceptions;

public class QuizzardException extends RuntimeException {
    public QuizzardException() {
        super("An exception has occurred");
    }

    public QuizzardException(String message) {
        super(message);
    }

    public QuizzardException(String message, Throwable cause) {
        super(message, cause);
    }
}
