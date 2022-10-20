package com.Lab_5.ClientProject.Client;

import com.Lab_5.ClientProject.Support.InputConsole;
import com.Lab_5.ClientProject.Client.ClientCommands.Help;

import java.util.LinkedList;

public class CommandsManager {

    public MyCommand start(){
        LinkedList<String> commands = new LinkedList<>();
        commands.add("help");
        Help.execute(commands);
        return new MyCommand();
//        commands.add(InputConsole.inputCommand());

//        boolean state = true;
//        while(state) {
//            /**
//             * //что делать если в скрипте ошибка во время выполнения команды
//             * во время не понимания команды
//             * продолжать дальше другие или заканчивать?
//             * лучше выполнить до него и выкинуть понятную ошибку, очевидно
//             * А как работает у меня?
//             */
//            try {
//                Call_commands.call(commands, data);
//                if(!(commands.size()!=0 && commands.getFirst().equals("exit")))
//                    commands.add(InputConsole.inputCommand());
//                else
//                    state = false;
//            }
//            catch(Exception ex){
//                System.out.println(ex);
//                commands.removeFirst();
//
//                commands.add(InputConsole.inputCommand());
//            }
//        }
//        System.out.println("The end of the programm. Goodbye and good luck!");
////        Call_commands.call(commands, data);
    }
}