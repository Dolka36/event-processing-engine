package com.dolka36.exception;

public class EngineProcessingException extends RuntimeException {
    public EngineProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
    public EngineProcessingException(String message){
        super((message));
    }
}
