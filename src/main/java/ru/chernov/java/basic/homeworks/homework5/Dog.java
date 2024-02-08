package ru.chernov.java.basic.homeworks.homework5;

public class Dog extends Animal {
    public Dog(String name, int runSpeed, int stamina, int swimSpeed) {
        super(name, runSpeed, stamina);
        this.swimSpeed = swimSpeed;
        this.staminaExpenseSwim = 2;
    }
}