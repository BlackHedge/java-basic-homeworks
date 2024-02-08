package ru.chernov.java.basic.homeworks.homework5;

public class Horse extends Animal {
    public Horse(String name, int runSpeed, int stamina, int swimSpeed) {
        super(name, runSpeed, stamina);
        this.swimSpeed = swimSpeed;
        this.staminaExpenseSwim = 4;
    }
}
