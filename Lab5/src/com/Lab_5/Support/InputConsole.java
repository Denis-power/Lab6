package com.Lab_5.Support;

import com.Lab_5.HumanBeing.Car;
import com.Lab_5.HumanBeing.Coordinates;
import com.Lab_5.HumanBeing.Mood;
import com.Lab_5.exceptions.InvalidMoodException;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;


/**
 * Класс для чтения данных из консоли
 */
public class InputConsole {

    private static final Scanner scan = new Scanner(System.in).useLocale(Locale.US).useDelimiter("\n");

    /**
     * Чтение команды
     * @return String имя команды
     */
    public static String inputCommand(){//валидация при поиске соответсвуюещей команды для выполения в классе Call_commands
        return InputValidation.commandValidation(scan);
    }

    /**
     * Чтение имени
     * @return String имя
     */
    public static String inputName(){//not null
//        System.out.println("Enter name. ");
        return InputValidation.nameVailidation(scan);
    }

    /**
     * Чтение координаты X
     * @return float X
     */
    public static float inputXcoordinate() {//not null
          System.out.println("Enter " + "this person" + "'s X coordinate as float number: ");
          return InputValidation.xcordinateValidation(scan);
    }

    /**
     * Чтение координаты Y
     * @return int Y
     */
    private static int inputYcoordinate() {
        System.out.println("Enter " + "this person" + "'s Y coordinate as integer number: ");
        return InputValidation.ycordinateValidation(scan);
    }

    /**
     * Чтение координат X and Y
     * @return class Coordinates
     */
    public static Coordinates inputCoordinates(){//not null
        return new Coordinates(inputXcoordinate(), inputYcoordinate());
    }

    /**
     * Чтение ответа на вопрос: является ли элемент realHero
     * @return boolean
     */
    public static boolean inputRealHero(){
        return InputValidation.realHeroValidation(scan);
    }
    /**
     * Чтение ответа на вопрос: имеет ли элемент toothPick
     * @return boolean
     */
    public static boolean inputHasToothPick() {//can be null
        return InputValidation.hasToothPickValidation(scan);
    }

    /**
     * Чтение скорости элемента
     * @return int
     */
    public static int inputImpactSpeed(){//max 60
        System.out.println("Enter integer number the person's impact speed in range [0;60]: ");
//        boolean state = false;
        return InputValidation.impactSpeedValidation(scan);
    }

    /**
     * Чтение имени саундтрека элемента
     * @return String
     */
    public static String inputSoundtrackName(){// not null
        return InputValidation.soundTrackNameVaildation(scan);
    }

    /**
     * Чтение количества минут, которые элемент ждет чего-то
     * @return int
     */
    public static int inputMinutesOfWaiting(){//not null
        System.out.println("Enter integer the person's minutes of waiting: ");
        return InputValidation.minutesOfWaitingValidation(scan);
    }

    /**
     * Чтение настроения элемента, можно вернуть null, если не знаешь
     * @return Mood
     */
    public static Mood inputMood(){// can be null
        System.out.println("Enter the person's mood or escape if don't know:\n" +
                "Availavle moods:\n" +
                "    sadness,\n" +
                "    apathy,\n" +
                "    frenzy;");
        return InputValidation.moodValidaiton(scan);
    }

    /**
     * Чтение имени машины и ее крутости, может быть null
     * @return class Car
     */
    public static Car inputCar(){//can be null
        return InputValidation.carValidation(scan);
    }

    /**
     * Получение ответа Yes или No
     * @return boolean
     */
    public static boolean YESorNO(){
        return InputValidation.YESorNO(scan);
    }

    /**
     * Получение натурального числа
     * @return long
     */
    public static long setNaturalNumber(){
        return InputValidation.setNaturalNumber(scan);
    }
}
