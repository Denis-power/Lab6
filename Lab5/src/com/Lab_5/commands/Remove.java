package com.Lab_5.commands;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputConsole;
import com.Lab_5.Support.InputValidation;

import java.util.LinkedList;
import java.util.ListIterator;

import static com.Lab_5.Support.InputConsole.YESorNO;

public class Remove implements Command {
    public class RemoveById {
        public static void execute(Data data, LinkedList<String> commands) {
            //1. Такого айди может не сущестовать, ну и что))
            long id = InputValidation.comandValidationSecondLong(commands);
            commands.removeFirst();//сразу удалаяем имя команды
            HumanBeing del_hum = data.get(id);
            Boolean ifYes = InputValidation.ifYESorNO(commands);
            //2. Айди не натуральное > 0
            if (del_hum != null) {
                if (ifYes == null) {
                    System.out.println("Do you want delete this element: \n" +
                            del_hum.toString());
                    if (YESorNO()) {
                        data.removeByIdInclusive(id, 1);
                        System.out.println("Element by id{" + id + "}" + " was removed.");
                    }
                    else
                        System.out.println("The remove operation was canceled");
                } else if (ifYes.equals(true)) {
                    data.removeByIdInclusive(id, 1);
                    System.out.println("Element by id{" + id + "}" + " was removed.");
                    commands.removeFirst();//удаляем yes
                } else if (ifYes.equals(false)) {
                    System.out.println("The remove operation was canceled");
                    commands.removeFirst();//удалаяем no
                }
            } else {
                System.out.println("Such element don't exist.\n" +
                        "Existing identifiers: ");

                ListIterator<HumanBeing> it = data.getdataSet().listIterator(0);
                String ides = "";
                while (it.hasNext()) {
                    ides += ("{" + it.next().getId().toString() + "} ");
                }
                if(data.getdataSet().size()==0)
                    System.out.println("don't exist");
                else
                    System.out.println(ides);
                if (ifYes != null)
                    commands.removeFirst();
            }
            data.setId();
        }
    }

    public class RemoveFirst {
        public static void execute(Data data, LinkedList<String> commands) {

            InputValidation.comandValidationOneArg(commands);
            commands.removeFirst();
            Boolean ifYes = InputValidation.ifYESorNO(commands);
            if(data.getdataSet().size() == 0) {
                System.out.println("Data haven't elements.");
                if(ifYes!=null)
                    commands.removeFirst();
                return;
            }
            if (ifYes == null) {
                System.out.println("Do you want delete first element?");
                if (YESorNO()) {
                    data.getdataSet().removeFirst();
                    System.out.println("First element was removed.");
                }
                else
                    System.out.println("The remove operation was canceled");
            } else if (ifYes.equals(true)) {
                data.getdataSet().removeFirst();
                System.out.println("First element was removed.");
                commands.removeFirst();
            } else if (ifYes.equals(false)) {
                System.out.println("The remove operation was canceled");
                commands.removeFirst();
            }
            data.setId();
        }
    }

    public class RemoveGreater {
        public static void execute(Data data, LinkedList<String> commands) {//доделать
            long id = InputValidation.comandValidationSecondLong(commands);
            commands.removeFirst();
            Boolean ifYes = InputValidation.ifYESorNO(commands);
            if (id < data.getdataSet().getLast().getId()) {
                if (ifYes == null) {
                    System.out.println("Are your sure you want to remove all elements which's id greater than {" + id + "}?");
                    removeInteractive(data, id);
                } else if (ifYes.equals(true)) {
                    data.removeByIdNonInclusive(id, data.getSize());
                    System.out.println("Elements by id greater {" + id + "}" + " were removed.");
                    commands.removeFirst();
                } else if (ifYes.equals(false)) {
                    System.out.println("The remove operation was canceled");
                    commands.removeFirst();
                } else
                    System.out.println("The remove operation was canceled");
//                commands.removeFirst();
            } else {
                System.out.println("Elements greater than Person[id=" + id + "] don't exist.");
                if (ifYes != null)
                    commands.removeFirst();
            }
            data.setId();
        }
    }


    private static void removeInteractive(Data data, long id) {
        if (YESorNO()) {
            data.removeByIdNonInclusive(id, data.getSize());
            System.out.println("Elements by id greater {" + id + "}" + " were removed.");
        } else
            System.out.println("The remove operation was canceled");
    }

    public class RemoveHead {
        public static void execute(Data data, LinkedList<String> commands) {
            InputValidation.comandValidationOneArg(commands);
            commands.removeFirst();
            Boolean ifYes = InputValidation.ifYESorNO(commands);
            if(data.getdataSet().size() == 0) {
                System.out.println("Data haven't elements.");
                if(ifYes!=null)
                    commands.removeFirst();
                return;
            }
            if (ifYes == null) {
                System.out.println("Do you want delete this elemenet? \n" +
                        data.getdataSet().getFirst().toString());
                if (YESorNO()) {
                    data.getdataSet().removeFirst();
                    System.out.println("First element was removed.");
                }
                else
                    System.out.println("The remove operation was canceled");
            } else if (ifYes.equals(true)) {
                data.getdataSet().removeFirst();
                System.out.println("First element was removed.");
                commands.removeFirst();
            } else if (ifYes.equals(false)) {
                System.out.println("The remove operation was canceled");
                commands.removeFirst();
            }
            data.setId();
        }//method
    }//smallclass
}//Bigclass
