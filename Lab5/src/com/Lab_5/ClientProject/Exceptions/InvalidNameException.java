package com.Lab_5.ClientProject.Exceptions;

public class InvalidNameException extends IllegalArgumentException{
    public InvalidNameException() {
        super("Illegal Name field has been entered.");
    }

    public InvalidNameException(String message) {
        super(message);
    }
}
