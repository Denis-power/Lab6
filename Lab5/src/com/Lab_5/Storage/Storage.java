package com.Lab_5.Storage;

import com.Lab_5.HumanBeing.Car;
import com.Lab_5.HumanBeing.Coordinates;
import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.HumanBeing.Mood;
import com.Lab_5.Support.Parser;
import com.Lab_5.Support.ReadFromFile;

import java.io.IOException;
import java.util.LinkedList;

public interface Storage {
    void add(String name, Coordinates coordinates, boolean realHero,
             Boolean hasToothpick, double impactSpeed, String soundtrackName, double minutesOfWaiting, Mood mood,
             Car car);
}
