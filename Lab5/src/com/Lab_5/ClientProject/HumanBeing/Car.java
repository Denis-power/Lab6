package com.Lab_5.ClientProject.HumanBeing;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private Boolean cool; //Поле может быть null

    public Car(){}
    public Car(String name, Boolean cool) {
        this.name = name;
        this.cool = cool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCool(Boolean cool) {
        this.cool = cool;
    }

    @Override
    public String toString() {
        if(this != null) {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", cool=" + cool +
                    '}';
        }
        return null;
    }
}
