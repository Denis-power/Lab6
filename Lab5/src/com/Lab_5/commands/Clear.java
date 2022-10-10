package com.Lab_5.commands;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;

import java.io.IOException;
import java.util.LinkedList;

public class Clear implements Command{
    public static void execute(Data data, LinkedList<String> scripts) throws IOException {
        InputValidation.comandValidationOneArg(scripts);
        data.clear();
        System.out.println("Data is clear.");
        scripts.removeFirst();
    }
}
