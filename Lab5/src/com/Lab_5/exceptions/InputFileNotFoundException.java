package com.Lab_5.exceptions;

import  java.io.FileNotFoundException;
public class InputFileNotFoundException extends FileNotFoundException {
    public InputFileNotFoundException(){
        super("Error. Input file not found.");
    }
}
