package com.fauxnancials.exceptions;

import static com.fauxnancials.util.AnsiColours.ANSI_RED;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super(ANSI_RED + "Invalid request." + ANSI_RESET);
    }
}
