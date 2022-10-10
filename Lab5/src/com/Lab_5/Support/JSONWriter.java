package com.Lab_5.Support;

import com.Lab_5.HumanBeing.HumanBeing;
import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;

public class JSONWriter<T> {


    public void writeToFile(String filename, T data) throws IOException, FileNotFoundException {
        //через стандартные методы json
        String json_data = new JSONValidation<T>().validation(data);
//        boolean success = true;

        FileOutputStream fout = new FileOutputStream(filename);

        OutputStreamWriter OSW = new OutputStreamWriter(fout, Charset.forName("UTF8"));

        OSW.write(json_data);

        OSW.close();

    }
}
