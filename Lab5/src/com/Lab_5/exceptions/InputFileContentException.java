package com.Lab_5.exceptions;

public class InputFileContentException extends IllegalArgumentException{
    public InputFileContentException() {
        super("Illegal context of file.");
    }

    public InputFileContentException(String message) {
        super(message);
    }
}
