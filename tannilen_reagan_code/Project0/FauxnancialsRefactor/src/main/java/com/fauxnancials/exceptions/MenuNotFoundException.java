package com.fauxnancials.exceptions;

import static com.fauxnancials.util.AnsiColours.*;

public class MenuNotFoundException extends RuntimeException {
    public MenuNotFoundException(){
        super(ANSI_RED + "Exception 404: menu not found." + ANSI_RESET);
    }
}
