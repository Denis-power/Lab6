package com.Lab_5.exceptions;

public class LoopingSriptsException extends IllegalArgumentException{
    public LoopingSriptsException() {
        super("Scripts looping.");
    }

    public LoopingSriptsException(String message) {
        super(message);
    }
}
