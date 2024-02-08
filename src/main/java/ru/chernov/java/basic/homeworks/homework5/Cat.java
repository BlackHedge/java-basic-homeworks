package ru.chernov.java.basic.homeworks.homework5;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int stamina) {
        super(name, runSpeed, stamina);
    }

    @Override
    public int swim(int distance) {
        int time = -1;
        System.out.println(name + " смотрит с обидой. Я кыся - я не умею! И у.е. тратить не буду!");
        return time;
    }
}
