package com.Lab_5.ClientProject.Exceptions;

import com.Lab_5.ClientProject.Exceptions.InvalidIdException;

public class InvalidToothPickException extends InvalidIdException {
    public InvalidToothPickException() {
        super("Illegal ToothPick field has been entered.");
    }

    public InvalidToothPickException(String message) {
        super(message);
    }
}
