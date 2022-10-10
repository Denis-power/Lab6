package com.Lab_5.commands;

import com.Lab_5.Storage.Data;

import java.util.LinkedList;

public interface Command {
    //void undo(T obj);
    static void execute(Data data, LinkedList<String> scripts){};
}
