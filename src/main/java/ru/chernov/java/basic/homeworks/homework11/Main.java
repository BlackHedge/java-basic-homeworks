package ru.chernov.java.basic.homeworks.homework11;

import java.util.Arrays;

import static ru.chernov.java.basic.homeworks.homework11.Position.*;

public class Main {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase();

        personDataBase.add(new Person(1763465745623L, "Momo", MANAGER));
        personDataBase.add(new Person(64545L, "Lilu", SENIOR_MANAGER));
        personDataBase.add(new Person(98765434L, "Poma", BRANCH_DIRECTOR));
        personDataBase.add(new Person(4873495L, "Tom", PLUMBER));
        personDataBase.add(new Person(298348957L, "Tori", DEVELOPER));
        personDataBase.add(new Person(956252L, "Swetlana", DRIVER));
        personDataBase.add(new Person(1L, "Serj", QA));
        System.out.println("Who is 1763465745623? - " + personDataBase.findById(1L).toString());
        System.out.println(personDataBase.findById(1763465745623L).getName() + " is Manager? - " +
                personDataBase.isManager(personDataBase.findById(1763465745623L)));
        System.out.println(personDataBase.findById(298348957L).getName() + " is Employee? - " +
                personDataBase.isEmployee(298348957L));

        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++) {
            intArray[i] = (int) (Math.random() * 100);
        }

        System.out.println("Initial arrayz" + Arrays.toString(intArray));
        ClassForArraySort.bubbleSort(intArray);
        System.out.println("After sorting " + Arrays.toString(intArray));
    }

}