package com.Lab_5.ClientProject.HumanBeing;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class HumanBeing implements Comparable<HumanBeing>, Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
//    @JsonFormat(pattern = )
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private double impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private double minutesOfWaiting;
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    public HumanBeing(){}

    public HumanBeing(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Boolean realHero,
                      boolean hasToothpick, double impactSpeed, String soundtrackName, double minutesOfWaiting, Mood mood,
                      Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.mood = mood;
        this.car = car;
    }
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero,
                      boolean hasToothpick, double impactSpeed, String soundtrackName, double minutesOfWaiting, Mood mood,
                      Car car){
        this.id = -1L;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.mood = mood;
        this.car = car;
    }

    public void initHumanBeing(){

//        Scanner scan = new Scanner(System.in);
//        String hastoothpick = scan.nextLine();
//        boolean isbool;
//        while(!("true".equals(hastoothpick) || "false".equals(hastoothpick) || "".equals(hastoothpick))) {
//            System.out.println("You entered not boolean. Enter again or escape.)");
//            scan.nextLine();
//        }
//        if (!hastoothpick.equals(""))
//            this.hasToothpick = Boolean.parseBoolean(hastoothpick);

    }


    /**
     * Getter for {@link #id}
     *
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter for {@link #name}
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public double getImpactSpeed() {
        return impactSpeed;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public void setImpactSpeed(double impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setMinutesOfWaiting(double minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }


    public void update(){

    }

    public String nullCheck(String forcheck){
        if(forcheck.equals(null)) {
            return "haven't or unknown";
        }
        else return forcheck;
    }

    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + "\'" +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", soundtrackName='" + soundtrackName + "\'" +
                ", minutesOfWaiting=" + minutesOfWaiting +
                ", mood=" + mood +
                ", car=" + car +
                '}';
    }

    public boolean equals(HumanBeing o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing chel = (HumanBeing) o;
        return minutesOfWaiting == chel.minutesOfWaiting &&
                Double.compare(chel.impactSpeed, impactSpeed) == 0 &&
                name.equals(chel.name) &&
                coordinates.equals(chel.coordinates) &&
                creationDate.equals(chel.creationDate) &&
                Objects.equals(hasToothpick, chel.hasToothpick) &&
                mood == chel.mood &&
                car.equals(chel.car);
    }

    @Override
    public int compareTo(HumanBeing o) {
        if (o.id > this.id) {
            return -1;
        }
        return 1;
    }

    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, mood, car);
    }
}
