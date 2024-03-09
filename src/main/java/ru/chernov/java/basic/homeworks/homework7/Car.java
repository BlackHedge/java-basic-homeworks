package ru.chernov.java.basic.homeworks.homework7;

import static ru.chernov.java.basic.homeworks.homework7.AreaType.PLAIN;

public class Car extends Transport implements Movement {
    private int fuel;
    private int fuelExpense;

    public Car(String brand, int fuel, int fuelExpense) {
        super(brand);
        this.fuel = fuel;
        this.fuelExpense = fuelExpense;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public boolean move(int distance, AreaType area) {
        if (!isBusy()) {
            System.out.println(getDescription() + " не может перемещаться без водителя");
            return false;
        }
        if (area != PLAIN) {
            System.out.println(getDescription() + " не может передвигаться по местности " + area.getAreaTypeName());
            return false;
        }
        if (distance <= (fuel / fuelExpense) * 100) {
            System.out.println(getDescription() + " перевозит " + getDriverName() + " на " + distance
                    + " по местности " + area.getAreaTypeName());
            fuel = fuel - ((distance / 100) * fuelExpense);
            return true;
        } else {
            System.out.println(getDescription() + " не хватает топлива");
            return false;
        }
    }
}