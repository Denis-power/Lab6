package com.Lab_5.commands;

import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputValidation;
import com.Lab_5.exceptions.InvalidCommandException;

import java.io.IOException;
import java.util.*;

public class Call_commands /*implements CommandManager*/{

//    HashMap<String, Command> namesAndCommands = new HashMap<>();
    static boolean globalState = true;

    public static void call(LinkedList<String> scripts, Data data) throws IOException {

        if(!globalState)
            scripts.addFirst("exit");
//        boolean
        while (true) {
            if(!globalState) {//конеу выполнения при exit
                scripts.addFirst("exit");
                break;
            }
            if((scripts.size()==0))//выход из скрипта, если закончились команды
                break;
            switch (scripts.get(0).split(" ")[0]) {//ввод команды
                case ("add"):
                    Add.execute(data, scripts);
                    break;
                case ("average_of_minutes_of_waiting"):
                    Average_of_minutes_of_waiting.execute(data, scripts);
                    break;
                case ("clear"):
                    Clear.execute(data, scripts);
                    break;
                case ("execute_script"):
                    Execute_script.execute(data, scripts);
                    break;
                case ("exit"):
                    Exit.execute(data, scripts);
                    globalState = false;
                    scripts.addFirst("exit");
                    break;
                case ("help"):
                    Help.execute(data, scripts);
                    break;
                case ("info"):
                    Info.execute(data, scripts);
                    break;
                case ("print_descending"):
                    Print.PrintDescending.execute(data, scripts);
                    break;
                case ("remove_by_id"):
                    Remove.RemoveById.execute(data, scripts);
                    break;
                case ("remove_first"):
                    Remove.RemoveFirst.execute(data, scripts);
                    break;
                case ("remove_greater"):
                    Remove.RemoveGreater.execute(data, scripts);
                    break;
                case ("remove_head"):
                    Remove.RemoveHead.execute(data, scripts);
                    break;
                case ("save"):
                    Save.execute(data, scripts);
                    break;
                case ("show"):
                    Print.Show.execute(data, scripts);
                    break;
                case ("update"):
                    Update.execute(data, scripts);
                    break;
                default:
//                    state = false;
//                    System.out.println("Unidentified command: {" + scripts.get(0).split(" ")[0] + "}\nCheck correctness of the entered data.");
//                    scripts.removeFirst();//не нашли команду -> удаляем ее
                    throw new InvalidCommandException("Unidentified command: {" + scripts.get(0) + "}\nCheck correctness of the entered data.");
            }
        }
    }
    public static boolean isCommand (String command){
        switch (command) {
            case ("add"):
                return true;
            case ("average_of_minutes_of_waiting"):
                return true;

            case ("clear"):
                return true;
            case ("execute_script"):
                return true;
            case ("exit"):
                return true;
            case ("help"):
                return true;
            case ("info"):
                return true;
            case ("print_descending"):
                return true;
            case ("remove_by_id"):
                return true;
            case ("remove_first"):
                return true;
            case ("remove_greater"):
                return true;
            case ("remove_head"):
                return true;
            case ("save"):
                return true;
            case ("show"):
                return true;
            case ("update"):
                return true;
            default:
//                System.out.println("Not valid format of entered commands.");
                return false;
        }
    }
}
