package com.Lab_5.commands;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class Average_of_minutes_of_waiting<T> implements Command {
    private static long average_of_minutes_of_waiting_(Data data){
        long average_of_minutes_of_waiting = 0;

        ListIterator<HumanBeing> it = data.getdataSet().listIterator(0);
        while (it.hasNext()) {
            average_of_minutes_of_waiting += it.next().getMinutesOfWaiting();
        }
        if(average_of_minutes_of_waiting != 0)
            average_of_minutes_of_waiting = average_of_minutes_of_waiting / data.getSize();
        return average_of_minutes_of_waiting;
    }
    public static void execute(Data data, LinkedList<String> scripts) throws IOException {
        InputValidation.comandValidationOneArg(scripts);
        System.out.println("Average of minutes of waiting: " + average_of_minutes_of_waiting_(data));
        scripts.removeFirst();
    }
}
