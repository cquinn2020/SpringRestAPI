package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timestamp;
    private String errorMessage;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String errorMessage, String details) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDetails() {
        return details;
    }
}
