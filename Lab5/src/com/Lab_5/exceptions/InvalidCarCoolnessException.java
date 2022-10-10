package com.Lab_5.exceptions;

public class InvalidCarCoolnessException extends IllegalArgumentException{
    public InvalidCarCoolnessException() {
        super("Illegal Car Coolness field has been entered.");
    }

    public InvalidCarCoolnessException(String message) {
        super(message);
    }
}
