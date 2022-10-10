package com.Lab_5.exceptions;

public class InJsonConversionException extends  IllegalArgumentException{
    public InJsonConversionException() {
        super("Error got while executing the conversion data in json format.");
    }

    public InJsonConversionException(String message) {
        super(message);
    }
}
