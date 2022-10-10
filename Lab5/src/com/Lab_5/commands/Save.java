package com.Lab_5.commands;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;
import com.Lab_5.Support.JSONWriter;

import java.io.IOException;
import java.util.LinkedList;


public class Save {

    public static void execute(Data data, LinkedList<String> commands) throws IOException {
        InputValidation.comandValidationOneArg(commands);
//        String storage_output_filename = "D:\\Denis\\Programs\\Java_codes\\Lab5\\src\\original.json";
        new JSONWriter<LinkedList<HumanBeing>>().writeToFile(data.getFilename_from(), data.getdataSet());

        System.out.println("Data were saved in file succeed.");
        commands.removeFirst();
    }
}
