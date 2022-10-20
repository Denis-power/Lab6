package com.Lab_5.ClientProject.Exceptions;

public class InvalidRealHeroException extends IllegalArgumentException{
    public InvalidRealHeroException() {
        super("Illegal RealHero field has been entered.");
    }

    public InvalidRealHeroException(String message) {
        super(message);
    }
}
