package com.Lab_5.ClientProject.Client.ClientCommands;

import com.Lab_5.ServerProject.Collection.Data;
import com.Lab_5.ClientProject.Support.InputValidation;

import java.util.LinkedList;

public class Exit {
    public static void execute(Data data, LinkedList<String> scripts){
        InputValidation.comandValidationOneArg(scripts);
        scripts.removeFirst();
    }
}
