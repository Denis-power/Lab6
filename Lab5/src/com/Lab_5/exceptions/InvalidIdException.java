package com.Lab_5.exceptions;

public class InvalidIdException extends IllegalArgumentException{
    public InvalidIdException(){
        super("Illegal id has been entered. Id should be unique, integer and more than '0'.");
}
    public InvalidIdException(String message) {
        super(message);
    }
}
