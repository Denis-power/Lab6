package com.Lab_5.commands;

import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;

import java.util.LinkedList;

public class Exit {
    public static void execute(Data data, LinkedList<String> scripts){
        InputValidation.comandValidationOneArg(scripts);
        scripts.removeFirst();
    }
}
