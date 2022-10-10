package com.Lab_5.exceptions;

public class InputCountOfArgumentsException extends IllegalArgumentException{
    public InputCountOfArgumentsException() {
        super("Illegal count of arguments.");
    }

    public InputCountOfArgumentsException(String message) {
        super(message);
    }
}
