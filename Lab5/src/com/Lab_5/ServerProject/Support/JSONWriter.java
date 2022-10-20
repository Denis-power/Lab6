package com.Lab_5.ServerProject.Support;

import java.io.*;
import java.nio.charset.Charset;

public class JSONWriter<T> {


    public void writeToFile(String filename, T data) throws IOException, FileNotFoundException {
        //через стандартные методы json
        String json_data = new JSONConvertetion<T>().validation(data);
//        boolean success = true;

        FileOutputStream fout = new FileOutputStream(filename);

        OutputStreamWriter OSW = new OutputStreamWriter(fout, Charset.forName("UTF8"));

        OSW.write(json_data);

        OSW.close();

    }
}
