package ru.chernov.java.basic.homeworks.homework7;

import static ru.chernov.java.basic.homeworks.homework7.AreaType.*;

/**
 * ДЗ 7. OTUS Java Basic. ООП Часть 3. Интерфейсы
 *
 * @author студент Максим Чернов
 */
public class Main {
    public static void main(String[] args) {
        Human human = new Human("Buddy");
        Car car = new Car("Honda", 42, 6);
        Rover rover = new Rover("Tractor Belarus", 120, 15);
        Horse horse = new Horse("Cherry", 50, 2);
        Bicycle bicycle = new Bicycle("Rock bike");

        human.takeTransport(car);
        human.takeTransport(horse);
        human.takeTransport(rover);
        human.move(500, SWAMP);
        human.takeOffTransport();
        car.move(500, PLAIN);
        human.takeTransport(rover);
        human.move(100, FOREST);
        horse.move(100, FOREST);
        bicycle.move(100, FOREST);

    }
}