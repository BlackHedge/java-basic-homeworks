package ru.chernov.java.basic.homeworks.homework6;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        System.out.print("Satiety of " + name + " is ");
        return satiety;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    private void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(int foodPortion) {
        if (foodPortion >= appetite) {
            setSatiety(true);
        } else {
            setSatiety(false);
        }
    }
}
