package com.Lab_5.ClientProject.Exceptions;

public class InvalidCarCoolnessException extends IllegalArgumentException{
    public InvalidCarCoolnessException() {
        super("Illegal Car Coolness field has been entered.");
    }

    public InvalidCarCoolnessException(String message) {
        super(message);
    }
}
