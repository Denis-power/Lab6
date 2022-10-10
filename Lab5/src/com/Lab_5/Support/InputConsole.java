package com.Lab_5.Support;

import com.Lab_5.HumanBeing.Car;
import com.Lab_5.HumanBeing.Coordinates;
import com.Lab_5.HumanBeing.Mood;
import com.Lab_5.exceptions.InvalidMoodException;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class InputConsole {

    private static final Scanner scan = new Scanner(System.in).useLocale(Locale.US).useDelimiter("\n");

    public static String inputCommand(){//валидация при поиске соответсвуюещей команды для выполения в классе Call_commands
        return InputValidation.commandValidation(scan);
    }

    public static String inputName(){//not null
//        System.out.println("Enter name. ");
        return InputValidation.nameVailidation(scan);
    }
    public static float inputXcoordinate() {//not null
          System.out.println("Enter " + "this person" + "'s X coordinate as float number: ");
          return InputValidation.xcordinateValidation(scan);
    }
    private static int inputYcoordinate() {
        System.out.println("Enter " + "this person" + "'s Y coordinate as integer number: ");
        return InputValidation.ycordinateValidation(scan);
    }
    public static Coordinates inputCoordinates(){//not null
        return new Coordinates(inputXcoordinate(), inputYcoordinate());
    }
    public static boolean inputRealHero(){
        return InputValidation.realHeroValidation(scan);
    }
    public static boolean inputHasToothPick() {//can be null
        return InputValidation.hasToothPickValidation(scan);
    }
    public static int inputImpactSpeed(){//max 60
        System.out.println("Enter integer number the person's impact speed in range [0;60]: ");
//        boolean state = false;
        return InputValidation.impactSpeedValidation(scan);
    }
    public static String inputSoundtrackName(){// not null
        return InputValidation.soundTrackNameVaildation(scan);
    }
    public static int inputMinutesOfWaiting(){//not null
        System.out.println("Enter integer the person's minutes of waiting: ");
        return InputValidation.minutesOfWaitingValidation(scan);
    }
    public static Mood inputMood(){// can be null
        System.out.println("Enter the person's mood or escape if don't know:\n" +
                "Availavle moods:\n" +
                "    sadness,\n" +
                "    apathy,\n" +
                "    frenzy;");
        return InputValidation.moodValidaiton(scan);
    }

    public static Car inputCar(){//can be null
        return InputValidation.carValidation(scan);
    }

    public static boolean YESorNO(){
        return InputValidation.YESorNO(scan);
    }

    public static long setNaturalNumber(){
        return InputValidation.setNaturalNumber(scan);
    }
}
