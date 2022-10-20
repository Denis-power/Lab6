package com.Lab_5.ClientProject.Support;

import com.Lab_5.ClientProject.Client.ClientCommands.Exit;
import com.Lab_5.ClientProject.Client.ClientCommands.Help;
import com.Lab_5.ClientProject.Client.MyCommand;
import com.Lab_5.ClientProject.Exceptions.InvalidCommandException;
import com.Lab_5.ClientProject.Exceptions.InvalidLongException;
import com.Lab_5.ClientProject.HumanBeing.HumanBeing;
import com.Lab_5.ClientProject.Support.InputConsole;
import com.Lab_5.ServerProject.Commands.*;

public class CommandValidation {

    public MyCommand validation(MyCommand myCommand) {//работа с аргументами
        String commandName = myCommand.getCommandName();
        if (commandName.equals("add")|| (commandName.equals("update") && !myCommand.getId().equals(-1L))) {
            //если нужно передать новый элемент
            myCommand.setTransfer(prepareHumanBeing());
            return myCommand;
        }
        if (commandName.equals("update") ||
                commandName.equals("remove_by_id") ||
                commandName.equals("remove_greater")) {
             //если нужно передать айди и проверить его существование
            Long id = Long.parseLong(myCommand.getArgs().getFirst());
            if(id<0)
                throw new InvalidLongException();
            myCommand.setId(Long.parseLong(myCommand.getArgs().getFirst()));//добавили id в переменную айди, проверю на существование в сервере, вернусь, подгтовлю, отправлю
            myCommand.getArgs().removeFirst();//убрали его из аргументов функции
            return myCommand;
        }

        if (commandName.equals("average_of_minutes_of_waiting") ||
                commandName.equals("clear") ||
                commandName.equals("help") ||
                commandName.equals("info") ||
                commandName.equals("print_descending") ||
                commandName.equals("remove_first") ||
                commandName.equals("remove_head") ||
                commandName.equals("show"))
            return myCommand;
        else
            throw new InvalidCommandException("Unidentified command: {" + myCommand.getCommandName() + "}\nCheck correctness of the entered data.");
    }

    private static HumanBeing prepareHumanBeing(){
        System.out.println("Creating new HumanBeing: ");
        return new HumanBeing(InputConsole.inputName(),
                InputConsole.inputCoordinates(),
                InputConsole.inputRealHero(),
                InputConsole.inputHasToothPick(),
                InputConsole.inputImpactSpeed(),
                InputConsole.inputSoundtrackName(),
                InputConsole.inputMinutesOfWaiting(),
                InputConsole.inputMood(),
                InputConsole.inputCar()
        );
    }
}
