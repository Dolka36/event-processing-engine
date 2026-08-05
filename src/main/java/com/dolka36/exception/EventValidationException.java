package com.dolka36.exception;

public class EventValidationException extends RuntimeException {
    public EventValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventValidationException(String message) {
        super(message);
    }
}
