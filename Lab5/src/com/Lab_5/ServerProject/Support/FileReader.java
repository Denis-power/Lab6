package com.Lab_5.ServerProject.Support;


import com.Lab_5.ServerProject.Exceptions.InputFileNotFoundException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *Класс для чтения данных из файла с помощью библиотеки BufferedInputStream
 */
public class FileReader implements ReadFromFile {

    /**
     * Метод для чтения данных из файла
     * @param filename
     * @return данные файла в форме String
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String readFromFile(String filename) throws FileNotFoundException, IOException {

        try {
            FileInputStream fin = new FileInputStream(filename);
            BufferedInputStream BIS = new BufferedInputStream(fin);
            int i = -1, counter = -1;
            char c;
            String str = "";
            while ((i = BIS.read()) != -1) {
                str += (char) i;
            }
            return str;
        } catch (FileNotFoundException ex) {
            throw new InputFileNotFoundException();
        }
    }
}
