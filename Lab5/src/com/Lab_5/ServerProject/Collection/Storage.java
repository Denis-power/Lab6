package com.Lab_5.ServerProject.Collection;

import com.Lab_5.ClientProject.HumanBeing.Car;
import com.Lab_5.ClientProject.HumanBeing.Coordinates;
import com.Lab_5.ClientProject.HumanBeing.Mood;

public interface Storage {
    void add(String name, Coordinates coordinates, boolean realHero,
             Boolean hasToothpick, double impactSpeed, String soundtrackName, double minutesOfWaiting, Mood mood,
             Car car);
}
