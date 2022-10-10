package com.Lab_5.exceptions;

public class InvalidCarNameException extends IllegalArgumentException{
    public InvalidCarNameException() {
        super("Illegal Car Name field has been entered.");
    }

    public InvalidCarNameException(String message) {
        super(message);
    }
}
