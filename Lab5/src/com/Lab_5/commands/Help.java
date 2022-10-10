package com.Lab_5.commands;

import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;

import java.util.LinkedList;

public class Help implements Command {
    public void undo(){}
    public static void execute(Data data, LinkedList<String> commands){
        InputValidation.comandValidationOneArg(commands);
        System.out.println("""
                These are available commands:\s
                   add {element}                     Add a new element to the collection
                   average_of_minutes_of_waiting     Print average value of "minutesOfWaiting" field for all elements
                   clear                             Clear collection
                   execute_script file_name          Read and execute a script from the specified file
                   exit                              terminate program (without saving to file)   group_counting_by_has_toothpick   Group the elements of the collection by the value of the hasToothpick field, display the number of elements in each group
                   help                              Display help on available commands
                   info                              Print information about the collection
                   print_descending                  Display the elements of the collection in descending order
                   remove_by_id id                   Remove element from collection by its id
                   remove_first                      Remove first element from collection
                   remove_greater id                 Remove all elements greater than the given
                   remove_head                       Print first element of the collection and remove it
                   save                              Save colletion to file
                   show                              Show collection
                   update id {element}               Update the value of the collection element whose id is equal to the given one"""
        );
        commands.removeFirst();
    }
}
