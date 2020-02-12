package com.revature.quizzard.exceptions;

public class QuizzardException extends RuntimeException {
    public QuizzardException() {
        super();
    }
    public QuizzardException(String msg) {
        super(msg);
    }
}
