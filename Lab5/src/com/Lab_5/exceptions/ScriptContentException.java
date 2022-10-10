package com.Lab_5.exceptions;

public class ScriptContentException extends IllegalArgumentException {
    public ScriptContentException() {
        super("Further implementation of the script canceled");
    }
    public ScriptContentException(String message) {
        super(message);
    }
}
