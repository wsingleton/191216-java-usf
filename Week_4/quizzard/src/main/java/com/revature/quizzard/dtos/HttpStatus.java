package com.revature.quizzard.dtos;

public enum HttpStatus {

    OK(200, "Request understood and processed successfully"),
    CREATED(201, "A new resource was created"),
    NO_CONTENT(204, "Request understood and processed, but there is no content to respond with"),
    BAD_REQUEST(400, "The server did not understand the request"),
    UNAUTHORIZED(401, "The requester is not an authenticated user"),
    FORBIDDEN(403, "The requester does not have the proper authorities "),
    NOT_FOUND(404, "The requested resource was not found"),
    CONFLICT(409, "The request created a resource conflict on the server"),
    INTERNAL_SERVER_ERROR(500, "An unexpected error occurred. This is a problem with the server, not the request");

    private int status;
    private String message;

    HttpStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
