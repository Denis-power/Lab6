package com.Lab_5.ServerProject.Commands;

import com.Lab_5.ServerProject.Exceptions.InputFileNotFoundException;
import com.Lab_5.ServerProject.Server.Call_commands;
import com.Lab_5.ServerProject.Collection.Data;
import com.Lab_5.ServerProject.Support.FileReader;
import com.Lab_5.ClientProject.Support.InputValidation;
import com.Lab_5.ClientProject.Exceptions.LoopingSriptsException;
import com.Lab_5.ClientProject.Exceptions.ScriptContentException;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class Execute_script implements Command {
    private static LinkedList<String> commands = new LinkedList<>();

    public static void execute(Data data, LinkedList<String> scr) throws IOException, InputFileNotFoundException {
        //сразу передать имя файла

        InputValidation.comandValidaionSecondString(scr);
        String filename = scr.get(0).split(" ")[1];
        String com = new FileReader().readFromFile(filename).trim();//прочитали файл
        //1) скрипт состоит из команды и перечисления переменных на следующих строках
        //хмм...
        //2) скрипт состоит их команды и переменной на той же строке
        //3) скрипт состоит из команты без перменных

        if (commands.contains(com)) {
            throw new LoopingSriptsException();
        }
        commands.add(com);//кинули прочитанную строку всего скрипта
        try {
            String com2 = com.replaceAll("[\r]", "");
            String[] coms = com2.split("\n");
            LinkedList<String> scripts = new LinkedList<>();
            Collections.addAll(scripts, coms);

            Call_commands.call(scripts, data);//кидаем массив построчных строк скрипта на выполнение
//            for(String i : script) {
//                Call_commands.call(i.trim().split(" "), data);//отправляем каждую команду по очереди на выполнение
//            }//можно посылать команды, пусть выполняются...
            commands.remove(com);
            scr.removeFirst();
            System.out.println("Script of file[" + filename + "] performed succeed.");
        } catch (Exception ex) {
            commands.remove(com);
            if(!(ex instanceof ScriptContentException))
                System.out.println("Error in script of file: " + filename + ".\n" + ex);
            throw new ScriptContentException();
        }
    }
}
