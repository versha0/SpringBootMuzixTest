package com.stackroute.MuzixApplication.exception;

public class MuzixAlreadyExists extends Exception {
    private String message;

    public MuzixAlreadyExists(String message) {
        super(message);
        this.message = message;
    }
}
