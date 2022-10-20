package com.Lab_5.ServerProject.Commands;

import com.Lab_5.ClientProject.HumanBeing.HumanBeing;
import com.Lab_5.ServerProject.Collection.Data;
import com.Lab_5.ClientProject.Support.InputValidation;
import com.Lab_5.ServerProject.Support.JSONWriter;

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
