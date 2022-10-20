package com.Lab_5.ClientProject.Exceptions;

public class InputCountOfArgumentsException extends IllegalArgumentException{
    public InputCountOfArgumentsException() {
        super("Illegal count of arguments.");
    }

    public InputCountOfArgumentsException(String message) {
        super(message);
    }
}
