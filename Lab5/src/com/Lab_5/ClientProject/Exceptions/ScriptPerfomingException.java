package com.Lab_5.ClientProject.Exceptions;

import java.util.IllegalFormatException;

public class ScriptPerfomingException extends IllegalArgumentException {
    public ScriptPerfomingException() {
        super("Error got while executing the script.");
    }

    public ScriptPerfomingException(String message) {
        super(message);
    }
}
