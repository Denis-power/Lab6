package com.Lab_5.ClientProject.Exceptions;

import com.Lab_5.ClientProject.Exceptions.InvalidHumanBeingException;

public class InvalidRefundableException extends InvalidHumanBeingException {
    public InvalidRefundableException(){
        super("Invalid refundable value has been entered. Refundable must be in {true, false, null}.");
    }
}
