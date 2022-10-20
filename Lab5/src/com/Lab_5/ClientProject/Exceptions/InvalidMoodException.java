package com.Lab_5.ClientProject.Exceptions;

public class InvalidMoodException extends IllegalArgumentException{
    public InvalidMoodException() {
        super("Illegal Mood field has been entered.");
    }

    public InvalidMoodException(String message) {
        super(message);
    }
}
