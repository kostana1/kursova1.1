package com.exception;

public class InvalidNumberException extends Exception {

    public InvalidNumberException() {
        super("Picked invalid number");
    }

    public InvalidNumberException(String message) {
        super(message);
    }
}
