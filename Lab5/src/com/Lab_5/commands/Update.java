package com.Lab_5.commands;

import com.Lab_5.HumanBeing.Car;
import com.Lab_5.HumanBeing.Coordinates;
import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputConsole;
import com.Lab_5.Support.InputValidation;
import com.Lab_5.exceptions.*;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.LinkedList;

import static com.Lab_5.Support.InputConsole.YESorNO;
import static com.Lab_5.Support.InputValidation.helpingMoodValidation;
import static com.Lab_5.Support.InputValidation.ifYESorNO;

public class Update {

    public static void execute(Data data, LinkedList<String> scripts) throws IOException {
        long id = InputValidation.comandValidationSecondLong(scripts);
        if (scripts.size()== 1 || Call_commands.isCommand(scripts.get(1).split(" ")[0])) {//если следующая строка это команда, ввод интерактивный
            if(!update(data.getdataSet(), id, scripts, true))
                System.out.println("Person with id=" + id + " don't exist.");
            else
                System.out.println("Person["+ id + "] updated." );
            scripts.removeFirst();
        }
        else {//следующая строка возможно переменная
            if(!update(data.getdataSet(), id, scripts, false)) {
                System.out.println("Person with id=" + id + " don't exist.");
                throw new ScriptContentException("Further implementation of the script canceled.");
//                while(!Call_commands.isCommand(scripts.getFirst().split(" ")[0])) {
//                    scripts.removeFirst();
//                    if(scripts.size() == 0)
//                        break;
//                }
            }
            else
                System.out.println("Person["+ id + "] updated." );
        }
    }

    private static boolean update(LinkedList<HumanBeing> l, long id, LinkedList<String> commands, boolean interactive) {
        if(id < 0 ){
            System.out.println("Id can't be less than 0");
            return false;
        }
        else {
            for (HumanBeing i : l) {
                if (id == i.getId()) {
                    if(interactive) {
                        System.out.println("Upddating Person[" + id + "]:");
                        i.setName(InputConsole.inputName());
                        i.setCoordinates(InputConsole.inputCoordinates());
                        i.setRealHero(InputConsole.inputRealHero());
                        i.setHasToothpick(InputConsole.inputHasToothPick());
                        i.setImpactSpeed(InputConsole.inputImpactSpeed());
                        i.setSoundtrackName(InputConsole.inputSoundtrackName());
                        i.setMinutesOfWaiting(InputConsole.inputMinutesOfWaiting());
                        i.setMood(InputConsole.inputMood());
                        i.setCar(InputConsole.inputCar());
                        return true;
                    }
                    else{
                        commands.removeFirst();

                        if(commands.get(0).matches(InputValidation.USERNAME_PATTERN))
                            i.setName(commands.get(0));
                        else
                            throw new InvalidNameException();
                        commands.removeFirst();

                        i.setCoordinates(new Coordinates(Double.parseDouble(commands.get(0)), Integer.parseInt(commands.get(1))));
                        commands.removeFirst();
                        commands.removeFirst();

                        i.setCreationDate(ZonedDateTime.now());

                        Boolean bool = ifYESorNO(commands);
                        if(bool == null)
                            throw new InvalidRealHeroException();

                        i.setRealHero(Boolean.parseBoolean(commands.get(0)));
                        commands.removeFirst();

                        bool = ifYESorNO(commands);
                        if(bool == null)
                            throw new InvalidToothPickException();
                        i.setHasToothpick(Boolean.parseBoolean(commands.get(0)));
                        commands.removeFirst();

                        i.setImpactSpeed(Double.parseDouble(commands.get(0)));
                        commands.removeFirst();

                        i.setSoundtrackName(commands.get(0));
                        commands.removeFirst();

                        i.setMinutesOfWaiting(Double.parseDouble(commands.get(0)));
                        commands.removeFirst();

                        i.setMood(helpingMoodValidation(commands.get(0)));//может пропустить мууд
                        commands.removeFirst();

                        if (commands.get(0).equals("yes")) {
                            commands.removeFirst();

                            Car carObj = new Car();

                            if(commands.get(0).matches(InputValidation.CARNAME_PATTERN))
                                carObj.setName(commands.get(0));
                            else
                                throw new InvalidCarNameException();
                            commands.removeFirst();

                            bool = ifYESorNO(commands);
                            commands.removeFirst();
                            if(bool == null)
                                throw new InvalidCarCoolnessException();

                            carObj.setCool(bool);
                            i.setCar(carObj);
                            return true;
                        }
                        else if (commands.get(0).equals("no")) {
                            commands.removeFirst();
                            return true;
                        }
                        else
                            throw new ScriptContentException();
                    }
                }
            }
            return false;
        }
    }
}
