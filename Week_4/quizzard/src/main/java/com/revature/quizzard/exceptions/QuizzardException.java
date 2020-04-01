package com.revature.quizzard.exceptions;

public class QuizzardException extends RuntimeException {

    public QuizzardException(Throwable e) {
        super("An unspecified exception was thrown, see logs for more information", e);
    }

}
