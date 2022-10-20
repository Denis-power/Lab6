package com.Lab_5.ServerProject.Support;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadFromFile {
    String readFromFile(String filename) throws FileNotFoundException, IOException;
}
