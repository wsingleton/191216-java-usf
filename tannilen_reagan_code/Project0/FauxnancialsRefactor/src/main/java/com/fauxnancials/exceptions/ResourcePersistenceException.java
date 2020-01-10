package com.fauxnancials.exceptions;

import static com.fauxnancials.util.AnsiColours.ANSI_RED;
import static com.fauxnancials.util.AnsiColours.ANSI_RESET;

public class ResourcePersistenceException extends RuntimeException {
    public ResourcePersistenceException() {
        super(ANSI_RED + "An unexpected exception has occurred.  Data has not been persisted." + ANSI_RESET);
    }
    public ResourcePersistenceException(String msg) {
        super(msg);
    }
}
