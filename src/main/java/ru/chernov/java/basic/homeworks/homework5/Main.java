package ru.chernov.java.basic.homeworks.homework5;

/**
 * OTUS JAVA Basic
 * ДЗ №5
 *
 * @author студент Максим чернов
 */
public class Main {
    public static void main(String[] args) {
        int sprint = 200;
        Dog watchDog = new Dog("Mukhtar", 5, 700, 2);
        Horse whiteHorse = new Horse("Whiskey", 7, 1000, 1);
        Cat jpCat = new Cat("helloKitty", 15, 500);

        for (int lap = 1; lap < 4; lap++) {
            if (lap % 2 == 0) {
                System.out.println("--- Круг " + lap);
                watchDog.swim(sprint);
                whiteHorse.swim(sprint);
                jpCat.swim(sprint);
                System.out.println("--- Состояние плавцов на " + lap + " круге");
                watchDog.info();
                whiteHorse.info();
                jpCat.info();
            } else {
                System.out.println("--- Круг " + lap);
                watchDog.run(sprint);
                whiteHorse.run(sprint);
                jpCat.run(sprint);
                System.out.println("--- Состояние бегунов на " + lap + " круге");
                watchDog.info();
                whiteHorse.info();
                jpCat.info();
            }
        }
    }
}
