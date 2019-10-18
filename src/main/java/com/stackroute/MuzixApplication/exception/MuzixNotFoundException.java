package com.stackroute.MuzixApplication.exception;

public class MuzixNotFoundException extends Exception {
    private String message;

    public MuzixNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}

