package ru.chernov.java.basic.homeworks.homework6;

/**
 * ДЗ 6. OTUS Java Basic. ООП. Работа со строками
 *
 * @author студент Максим Чернов
 */
public class Main {
    public static void main(String[] args) {
        Plate plateWithFood = new Plate(150);

        Cat[] hungryCats = {
                new Cat("Korzh", 10),
                new Cat("Belyash", 35),
                new Cat("Sevastopol", 50),
                new Cat("Kefir", 15),
                new Cat("Kosha", 30),
                new Cat("Mokka", 30),
                new Cat("Barsik", 20),
        };
        plateWithFood.addFood(50);
        for (Cat cat : hungryCats) {
            cat.eat(plateWithFood.getCurrentAmountFood());
            plateWithFood.decreaseFood(cat.getAppetite());
        }
        for (Cat cat : hungryCats) System.out.println(cat.isSatiety());
    }
}
