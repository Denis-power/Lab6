package com.Lab_5.main;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Storage.StorageManager;
import com.Lab_5.Support.*;
import com.Lab_5.commands.Add;

import java.util.LinkedList;
import java.util.Scanner;

// надо сделать с 5 по 7 (исключая части, связанные с базами данных, оставить запись в файл)
// + solid
// вариант 1231

/**
 * Продумать программу для согласования с лабами 6, 7? Можно повторять за 47iq))
 * --Непонятно, как с помощью переменной окружения читать даные из файла
 * читаем данные из csv файла с обработкой неправильных введенных данных
 * чтение: java.util.Scanner; запись: java.io.PrintWriter
 * данные записываем в сортированном виде в коллекцию типа java.util.LinkedHashSet
 * добавляем команды, которые сможет выполнять наша программа с данными в файле
 * при написании пишем документацию javadoc
 *
 * Для ввода значений null использовать пустую строку.
 *
 */

/**
 * считывание с джсон файла данных в коллекцию ---
 * вывод доступных команд ---
 * реализация команд адд, хелп ---
 * Разобраться с удобным выполнением команд---
 * как вводить данные, пока они не станут корректными
 * затем все остальные
 */

public class Main {


    /**
     * Class which starts the program
     * @autor Denis-Power
     * @version 1.0
     */

    public static void main(String[] args){
        try{
//            if (args.length == 0)
//                throw new InputFileNotFoundException();
            String fileName  = "D:\\Denis\\Programs\\Java_codes\\Lab5\\src\\collection.json";
            Data data = new Data(fileName, new JSONparser(), new FileReader());
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
