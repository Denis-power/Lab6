package com.Lab_5.main;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Storage.StorageManager;
import com.Lab_5.Support.*;
import com.Lab_5.commands.Add;
import com.Lab_5.exceptions.InputFileNotFoundException;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    /**
     * Class which starts the program
     * @autor Denis-Power
     * @version 1.0
     */

    public static void main(String[] args){
        try{
            if (args.length == 0)
                throw new InputFileNotFoundException();
//            String fileName  = "D:\\Denis\\Programs\\Java_codes\\Lab5\\src\\collection.json";
            Data data = new Data(args[0], new JSONparser(), new FileReader());
            StorageManager LinkedListManager = new StorageManager(data);
        }
        catch(Exception ex){
            if(ex.getMessage() != null){
                System.err.println(ex.getMessage());
            System.err.println("Error got while executing the program.");
            }
        }
    }

}
