package com.Lab_5.ClientProject.Exceptions;

public class InputValueNotYesOrNo extends IllegalArgumentException{
    public InputValueNotYesOrNo() {
        super("Illegal input value. It's not \"Yes\" or \"No\".");
    }
    public InputValueNotYesOrNo(String message) {
        super(message);
    }
}
