package com.Lab_5.ClientProject.HumanBeing;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private double x; //Поле не может быть null
    private int y;

    public Coordinates(){}
    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}