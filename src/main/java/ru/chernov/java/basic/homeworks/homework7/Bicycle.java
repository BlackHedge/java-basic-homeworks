package ru.chernov.java.basic.homeworks.homework7;

import static ru.chernov.java.basic.homeworks.homework7.AreaType.*;

public class Bicycle extends Transport implements Movement {


    public Bicycle(String type) {
        super(type);
    }

    @Override
    public boolean move(int distance, AreaType area) {
        if (!isBusy()) {
            System.out.println(getDescription() + " не может перемещаться без водителя");
            return false;
        }
        if (area == SWAMP) {
            System.out.println(getDescription() + " не может передвигаться по местности " + area.getAreaTypeName());
            return false;
        }
        System.out.println(getDescription() + " перевозит " + getDriverName() + " на " + distance
                + " по местности " + area.getAreaTypeName());
        return true;
    }
}