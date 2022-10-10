package com.Lab_5.Storage;

import com.Lab_5.Support.InputConsole;
import com.Lab_5.Support.Parser;
import com.Lab_5.commands.Command;
import com.Lab_5.commands.Call_commands;
import com.Lab_5.commands.Help;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class StorageManager {

    public StorageManager(Data data) throws IOException {
        LinkedList<String> commands = new LinkedList<>();
        commands.add("help");
        Help.execute(data, commands);
        commands.add(InputConsole.inputCommand());
        boolean state = true;
        while(state) {
            /**
             * //что делать если в скрипте ошибка во время выполнения команды
             * во время не понимания команды
             * продолжать дальше другие или заканчивать?
             * лучше выполнить до него и выкинуть понятную ошибку, очевидно
             * А как работает у меня?
             */
            try {
                Call_commands.call(commands, data);
                if(!(commands.size()!=0 && commands.getFirst().equals("exit")))
                    commands.add(InputConsole.inputCommand());
                else
                    state = false;
            }
            catch(Exception ex){
                System.out.println(ex);
                commands.removeFirst();

                commands.add(InputConsole.inputCommand());
            }
        }
        System.out.println("The end of the programm. Goodbye and good luck!");
//        Call_commands.call(commands, data);
    }
}