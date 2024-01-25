package ru.chernov.java.basic.homeworks.homework1;

import java.util.Scanner;

public class MainApplication {
    public static void main (String[] args) {
        //ДЗ(*)
        byte choiceMethod;
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите число от 1 до 5");
        choiceMethod = scanner.nextByte ();

        if (choiceMethod == 1) {
            greetings ();
        } else if (choiceMethod == 2) {
            //уменьшаем на 0.5, что "рандомизировать" знак аргумента
            int rndA = (int) ((Math.random () - 0.5) * 100);
            int rndB = (int) ((Math.random () - 0.5) * 100);
            int rndC = (int) ((Math.random () - 0.5) * 100);
            checkSign (rndA, rndB, rndC);
        } else if (choiceMethod == 3) {
            selectColor ();
        } else if (choiceMethod == 4) {
            compareNumbers ();
        } else if (choiceMethod == 5) {
            int rndInitValue = (int) ((Math.random () - 0.5) * 100);
            int rndDelta = (int) ((Math.random () - 0.5) * 100);
            boolean rndIncrement = false;

            if ((Math.random () - 0.5) * 10 < 0) {
                rndIncrement = false;
            } else {
                rndIncrement = true;
            }
            addOrSubtractAndPrint (rndInitValue, rndDelta, rndIncrement);
        } else {
            System.out.println ("Указанный метод недоступен");
        }

    }

    //ДЗ(1)
    public static void greetings () {
        System.out.println ("Hello");
        System.out.println ("World");
        System.out.println ("from");
        System.out.println ("Java");
    }

    //ДЗ(2)
    public static void checkSign (int a, int b, int c) {
        int sumOfArgs = a + b + c;
        if (sumOfArgs >= 0) {
            System.out.println ("Сумма положительная");
        } else {
            System.out.println ("Сумма отрицательная");
        }
    }

    //ДЗ(3)
    private static void selectColor () {
        int data = 500;
        if (data <= 10) {
            System.out.println ("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println ("Желтый");
        } else {
            System.out.println ("Зеленый");
        }
    }

    //ДЗ(4)
    private static void compareNumbers () {
        int a = 12;
        int b = -30;
        if (a >= b) {
            System.out.println ("a >= b");
        } else {
            System.out.println ("a < b");
        }
    }

    //ДЗ(5)
    private static void addOrSubtractAndPrint (int initValue, int delta, boolean increment) {
        int result;
        if (increment == true) {
            result = initValue + delta;
            System.out.println (result);
        } else {
            result = initValue - delta;
        }
    }
}
