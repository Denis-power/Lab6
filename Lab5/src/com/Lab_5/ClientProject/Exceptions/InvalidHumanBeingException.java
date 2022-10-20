package com.Lab_5.ClientProject.Exceptions;

public class InvalidHumanBeingException extends IllegalArgumentException{
    public InvalidHumanBeingException() {
        super("Illegal HumanBeing field has been entered.");
    }

    public InvalidHumanBeingException(String message) {
        super(message);
    }
}