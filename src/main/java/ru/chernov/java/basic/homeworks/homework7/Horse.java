package ru.chernov.java.basic.homeworks.homework7;

import static ru.chernov.java.basic.homeworks.homework7.AreaType.*;


public class Horse extends Transport implements Movement {
    private int power;
    private int powerExpense;

    public Horse(String name, int power, int powerExpense) {
        super(name);
        this.power = power;
        this.powerExpense = powerExpense;
    }

    @Override
    public boolean move(int distance, AreaType area) {
        if (!isBusy()) {
            System.out.println(getDescription() + " без наездника ускакала в неизвестном направлении");
            return false;
        }
        if (area == SWAMP) {
            System.out.println(getDescription() + " не может передвигаться по местности " + area.getAreaTypeName());
            return false;
        }
        if (distance <= (power / powerExpense) * 100) {
            System.out.println(getDescription() + " перевозит " + getDriverName() + " на " + distance
                    + " по местности " + area.getAreaTypeName());
            power = power - ((distance / 100) * powerExpense);
            return true;
        } else {
            System.out.println(getDescription() + " не хватает сил");
            return false;
        }
    }
}