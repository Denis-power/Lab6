package com.Lab_5.ClientProject.Exceptions;

public class InvalidCommandException extends IllegalArgumentException{
    public InvalidCommandException(){super("Illegal Command has been entered.");}
    public InvalidCommandException(String message){super(message);}
}
