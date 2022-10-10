package com.Lab_5.exceptions;

public class InvalidHumanBeingException extends IllegalArgumentException{
    public InvalidHumanBeingException() {
        super("Illegal HumanBeing field has been entered.");
    }

    public InvalidHumanBeingException(String message) {
        super(message);
    }
}