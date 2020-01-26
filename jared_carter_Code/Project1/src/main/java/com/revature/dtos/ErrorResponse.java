package com.revature.dtos;

import java.util.Objects;

public class ErrorResponse {

    private Integer status;
    private String message;
    private Long timestamp;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(Integer status, Long timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    public ErrorResponse(Integer status, String message, Long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public ErrorResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public ErrorResponse setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return status == that.status &&
                timestamp == that.timestamp &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, timestamp);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}