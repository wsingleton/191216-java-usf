package com.revature.reimbursement_app.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource(s) found");
    }

}
