package com.Lab_5.exceptions;

public class InvalidToothPickException extends InvalidIdException{
    public InvalidToothPickException() {
        super("Illegal ToothPick field has been entered.");
    }

    public InvalidToothPickException(String message) {
        super(message);
    }
}
