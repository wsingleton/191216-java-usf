package com.revature.quizzard.flashcard.dtos;

import java.util.Objects;

public class ErrorResponse {

    private int status;
    private String message;
    private long timestamp;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(int status, String message, long timestamp) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, status, timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ErrorResponse))
            return false;
        ErrorResponse other = (ErrorResponse) obj;
        return Objects.equals(message, other.message) && status == other.status && timestamp == other.timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
    }

}
