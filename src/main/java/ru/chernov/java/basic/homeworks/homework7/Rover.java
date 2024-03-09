package ru.chernov.java.basic.homeworks.homework7;

public class Rover extends Transport implements Movement {
    private int fuel;
    private int fuelExpense;

    public Rover(String type, int fuel, int fuelExpense) {
        super(type);
        this.fuel = fuel;
        this.fuelExpense = fuelExpense;
    }

    @Override
    public boolean move(int distance, AreaType area) {
        if (!isBusy()) {
            System.out.println(getDescription() + " не может перемещаться без водителя");
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