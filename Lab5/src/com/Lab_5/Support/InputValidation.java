package com.Lab_5.Support;

import com.Lab_5.HumanBeing.Car;
import com.Lab_5.HumanBeing.Coordinates;
import com.Lab_5.HumanBeing.Mood;
import com.Lab_5.commands.Add;
import com.Lab_5.commands.Help;
import com.Lab_5.exceptions.InputCountOfArgumentsException;
import com.Lab_5.exceptions.InvalidLongException;
import com.Lab_5.exceptions.InvalidMoodException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Прием валидных данных с консоли
 */
public class InputValidation {

    /**
     * Паттерн для имени персоны
     */
    public static final String USERNAME_PATTERN =
            "^[A-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,18}[a-zA-Z0-9.]$";
    /**
     * Паттерн для имени машины
     */
    public static final String CARNAME_PATTERN =
            "^([._ -](?![._ -])|[a-zA-Z0-9]){2,40}$";

    /**
     * Проверка на то, что введенная команда содержит только одно слово
     * @param commands
     * @throws InputCountOfArgumentsException
     */
    public static void comandValidationOneArg(LinkedList<String> commands) throws InputCountOfArgumentsException{
        if (commands.get(0).split(" ").length > 1)//чисто команда
            throw new InputCountOfArgumentsException();
    }

    /**
     * Проверка на то, что введенная команда содержит второй переменной значение числа long
     * @param commands
     * @return прочитанное число long, если содержит
     * @throws InvalidLongException
     */
    public static long comandValidationSecondLong(LinkedList<String> commands) throws InvalidLongException {
        try{
            return Long.parseLong(commands.get(0).split(" ")[1]);// чисто команда с аргументом long
        }
        catch(Exception ex) {
            throw new InvalidLongException();
        }
    }


    /**
     * Провера на то, что строка команды содержит из названия и аргумента
     * @param commands
     */
    public static void comandValidaionSecondString(LinkedList<String> commands){
        String[] temp = commands.get(0).trim().split(" ");
        if(temp.length != 2)
            throw new InputCountOfArgumentsException();
    }

    /**
     * Чтение команды из консоли
     * @param scan
     * @return String прочитанная команда
     */
    protected static String commandValidation(Scanner scan){
        System.out.println("Enter command: ");
        return scan.nextLine().trim();
    }

    /**
     * Чтение имени, чтобы подходило под условия
     * @param scan
     * @return name
     */
    protected static String nameVailidation(Scanner scan){
        System.out.println("Name requirments:\n" +
                "1. Start with uppercase letter or number and end with alphanumeric character or dot(.).\n" +
                "2. The username consists of alphanumeric characters (a-zA-Z0-9), lowercase or uppercase.\n" +
                "3. The username is allowed with a dot (.), underscore (_), and hyphen (-).\n" +
                "4. A period (.), underscore (_), or hyphen (-) must not be the first or last character.\n" +
                "5. Period (.), underscore (_), or hyphen (-) are not displayed consistently, e.g. java.. regular expression\n" +
                "6. The number of characters must be between 3 and 20.");
        System.out.println("Enter name:");
        String name = scan.nextLine();


        while(!name.matches(USERNAME_PATTERN)) {
            System.out.println("Entered name doesn't satisfy the requirements");
            name = scan.nextLine();

//            matcher = pattern.matcher(name);
        }
        return name;
    }

    /**
     * Чтение числа float, как координаты X
     * @param scan
     * @return float
     */
    protected static float xcordinateValidation(Scanner scan){
        while (!scan.hasNextFloat()) {
            System.out.println("You entered not float number. Try again. Example: 8.8");
            scan.next();
        }
        return scan.nextFloat();
    }

    /**
     * Чтение числа int, как координаты Y
     * @param scan
     * @return int
     */
    protected static int ycordinateValidation(Scanner scan){
        while (!scan.hasNextInt()) {
            System.out.println("You entered not int number. Try again. Example: 8");
            scan.next();
        }
        return scan.nextInt();
    }

    /**
     * Чтение ответа на вопрос, является ли person Real Hero
     * @param scan
     * @return boolean
     */
    protected static boolean realHeroValidation(Scanner scan){
        System.out.println("The person is real Hero?");
        return YESorNO(scan);
    }
    protected static boolean hasToothPickValidation(Scanner scan){//can be null
        System.out.println("The person has tooth pick?");
        return YESorNO(scan);
    }

    protected static int impactSpeedValidation(Scanner scan){
        int speed = -1;
        while(speed > 60 || speed < 0) {
            while (!scan.hasNextInt()) {
                System.out.println("You entered not int number. Try again.");
                scan.next();
            }
            speed = scan.nextInt();
            if(speed > 60 || speed < 0){
                System.out.println("Impact speed cannot be out of range [0; 60]");
            }
        }
        return speed;
    }
    protected static String soundTrackNameVaildation(Scanner scan){
        System.out.println("Enter person's soundtrack name: ");
        String s;
        s = scan.next();
        s = s.trim();//removing spaces
        while(s.equals("")){
            System.out.println("You entered empty string. Enter not empty string:");
            s = scan.nextLine().trim();
        }
        return s;
    }

    protected static int minutesOfWaitingValidation(Scanner scan){
        int minutes = -1;
        while(minutes < 0) {
            while (!scan.hasNextInt()) {
                System.out.println("You entered not int number. Try again.");
                scan.next();
            }
            minutes = scan.nextInt();
            if(minutes < 0){
                System.out.println("Minutes cannot be less than 0.");
            }
        }
        return minutes;
    }
    public static Mood helpingMoodValidation(String mood){
        switch (mood) {
            case  ("sadness"):
                return Mood.SADNESS;
            case ("apathy"):
                return Mood.APATHY;
            case ("frenzy"):
                return Mood.FRENZY;
            case(""):
                return null;
            default:
                throw new InvalidMoodException();
        }
    }
    protected static Mood moodValidaiton(Scanner scan){
        boolean state = true;
        Mood  mood = null;
        String mood_str;
        while(state) {
            try {
                state = false;
                mood_str = scan.next();
                mood = helpingMoodValidation(mood_str);
            } catch (InvalidMoodException ex) {
                state = true;
                if (ex.getMessage() != null) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return mood;
    }
    private static String carNameVAlidation(Scanner scan){
        System.out.println("Car name requirments:\n" +
                "   1. The car name consists of alphanumeric characters (a-za-Z0-9), lowercase or uppercase.\n" +
                "   2. The username is allowed with a dot (.), underscore (_), and hyphen (-).\n" +
                "   3. A period (.), underscore (_), or hyphen (-) must not be the first or last character.\n" +
                "   4. Period (.), underscore (_), or hyphen (-) are not displayed consistently, e.g. java.. regular expression\n" +
                "   5. The number of characters must be between 2 and 20.");
        System.out.println("Enter the person's Car name: ");
        String name = scan.nextLine();

        while(!name.matches(CARNAME_PATTERN)) {
            System.out.println("Entered name doesn't satisfy the requirements");
            name = scan.nextLine().trim();
        }
        return name;
    }
    private static boolean carCoolnessValidation(Scanner scan){
        System.out.println("Person's car is cool?");
        return YESorNO(scan);
    }

    protected static Car carValidation(Scanner scan){
        System.out.println("Has the person a car? ");
        if(YESorNO(scan))
            return new Car(carNameVAlidation(scan), carCoolnessValidation(scan));
        else
            return null;
    }
    public static Car carValidaion_without_interactive(String name, boolean collness){
        return new Car(name, collness);
    }

    protected static boolean YESorNO(Scanner scan){
        System.out.println("Enter \"yes\" or \"no\":");
        String inputStr = "";
        inputStr = scan.nextLine();
        if(inputStr.equals(""))
            inputStr = scan.nextLine();
        while(!(inputStr.equals("Yes") || inputStr.equals("yes")|| inputStr.equals("No")|| inputStr.equals("no"))){
            System.out.println("You entered not valid response. Enter \"yes\" or \"no\":");
            inputStr = scan.nextLine();
        }
        return inputStr.equals("Yes") || inputStr.equals("yes");
    }

    public static Boolean ifYESorNO(LinkedList<String>commands){
        if(commands.size()!=0){
            if(commands.get(0).equals("Yes")||commands.get(0).equals("yes"))
                return true;
            if(commands.get(0).equals("No")||commands.get(0).equals("no"))
                return false;
        }
        return null;
    }

    protected static long setNaturalNumber(Scanner scan){
        System.out.println("Enter natural number > 0 :");

        long id = scan.nextLong();
        while(id < 0){
            System.out.println("You entered not valid response. Enter natural number > 0:");
            id = scan.nextLong();
        }
        return id;
    }

//    public long idValidation(LinkedList<T> data, long id){
//
//    }

}