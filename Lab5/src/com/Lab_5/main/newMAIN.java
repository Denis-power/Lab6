package com.Lab_5.main;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.Support.FileReader;
import com.Lab_5.Storage.Data;
import com.Lab_5.Support.InputConsole;
import com.Lab_5.Support.JSONValidation;
import com.Lab_5.Support.JSONparser;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class newMAIN {

    private static Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) throws IOException {

        String fileStr = new FileReader().readFromFile("D:\\Denis\\Programs\\Java_codes\\Lab5\\src\\script1.txt");
        fileStr = fileStr.replaceAll("[\r]", "");
        System.out.println(fileStr);
    }

    public static boolean keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        return key==KeyEvent.VK_ENTER;
    }
}


