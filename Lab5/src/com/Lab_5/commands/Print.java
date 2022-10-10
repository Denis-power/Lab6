package com.Lab_5.commands;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;

import java.util.LinkedList;
import java.util.ListIterator;

public class Print implements Command{


    public void execute(Data data, LinkedList<String> scripts) {

    }

    public class PrintDescending {

        public static void execute(Data data, LinkedList<String> commands) {
            if (data.getSize() != 0) {
                System.out.println("Descending order of elements: ");
                ListIterator<HumanBeing> it = data.getdataSet().listIterator((int) data.getSize());
                while (it.hasPrevious())
                    System.out.println(it.previous().toString());
            }
            else
                System.out.println("Data is empty");
            commands.removeFirst();
        }
    }

    public class Show {
        public static void execute(Data data, LinkedList<String> commands) {
            InputValidation.comandValidationOneArg(commands);
            if (data.getSize() != 0){
                System.out.println("Increasing order of elements: ");
                print(data, 1);
        }
            else
                System.out.println("Data is empty.");
            commands.removeFirst();
        }
    }
    private static void print(Data data, int id){
        ListIterator<HumanBeing> it = data.getdataSet().listIterator((id - 1));
        while (it.hasNext())
            System.out.println(it.next().toString());
    }

}
