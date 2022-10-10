package com.Lab_5.exceptions;

public class InvalidRefundableException extends InvalidHumanBeingException{
    public InvalidRefundableException(){
        super("Invalid refundable value has been entered. Refundable must be in {true, false, null}.");
    }
}
