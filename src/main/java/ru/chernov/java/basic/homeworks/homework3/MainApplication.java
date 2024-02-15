package ru.chernov.java.basic.homeworks.homework3;

import java.util.Arrays;

/**
 * Домашнее задание Java #3
 *
 * @author студент Максим Чернов
 */
public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Sum of positive items is - " +
                sumOfPositiveElements((getArray(5, 5))));
        printAsteriskSquare(5);
        fillDiagonal(getArray(5, 5));
        int[][] arrayForMax = getArray(4, 3);
        int maxValue = findMax(arrayForMax);
        System.out.println("The " + maxValue + " is max in array " + Arrays.deepToString(arrayForMax));
        sumOfSelectedRowOfArray(getArray(10, 3), 2);
    }

    /**
     * Метод получает на вход двумерный целочисленный массив
     *
     * @return возвращает сумму всех элементов массива
     */
    public static int sumOfPositiveElements(int[][] anyArray) {
        int sumOfPos = 0;
        for (int i = 0; i < anyArray.length; i++) {
            for (int j = 0; j < anyArray[i].length; j++) {
                if (anyArray[i][j] > 0) {
                    sumOfPos += anyArray[i][j];
                }
            }
        }
        return sumOfPos;
    }

    /**
     * Метод получает на вход целое число для создания двумерного символльного массива
     * с количеством строк и столбцов, заданным этим числом. Заполняет массив символом '*'.
     *
     * @return также возвращает полученный массив
     */
    public static char[][] printAsteriskSquare(int size) {
        char[][] arrForSqr = new char[size][size];
        for (int i = 0; i < arrForSqr.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arrForSqr[i].length; j++) {
                arrForSqr[i][j] = '*';
                System.out.print(arrForSqr[i][j] + "|");
            }
            System.out.println();
        }
        return arrForSqr;
    }

    /**
     * Метод получает на вход "квадратный" массив.
     * Заполняет его диагонали нулями.
     * Выводит массив в консоль в формате матрицы.
     *
     * @param sqrArr квадратный массив
     * @return возвращает изменный массив sqrArr
     */
    public static int[][] fillDiagonal(int[][] sqrArr) {
        System.out.println("filling diagonal start");
        for (int i = 0; i < sqrArr.length; i++) {
            System.out.print("|");
            for (int j = 0; j < sqrArr[i].length; j++) {
                if (i == j || i == sqrArr[i].length - 1 - j) {
                    sqrArr[i][j] = 0;
                }
                System.out.print(sqrArr[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("filling diagonal end");
        return sqrArr;
    }

    /**
     * Поиск максимального значения в двумерном целочисленном массиве
     *
     * @param array двумерный массив
     * @return возвращает максимальное значение
     */
    public static int findMax(int[][] array) {
        int maxValueOfArray = 0;
        for (int index1Level = 0; index1Level < array.length; index1Level++) {
            for (int index2Level = 0; index2Level < array[index1Level].length; index2Level++) {
                if (array[index1Level][index2Level] > maxValueOfArray) {
                    maxValueOfArray = array[index1Level][index2Level];
                }
            }
        }
        return maxValueOfArray;
    }

    /**
     * Метод считает сумму элементов выбранной строки (с т.з. пользователя).
     * Получает на вход двумерный массив и строку для подсчета.
     * Проверяет количество "строк" массива.
     *
     * @param initArray двумерный массив
     * @param rowNum    проверяемая строка
     * @return возвращает сумму выбранной строки. Если строки нет возвращает -1
     */
    public static int sumOfSelectedRowOfArray(int[][] initArray, int rowNum) {
        System.out.println("sumOfSelectedRowOfArray is running");
        int sumOfRow = 0;
        int realIndexOfRow = rowNum - 1;
        System.out.println("check array " + Arrays.deepToString(initArray));
        System.out.println("search " + rowNum + " row in array");
        for (int row = 0; row < initArray.length; row++) {
            if (initArray.length < rowNum) {
                int code = -1;
                System.out.println("row is not found. code " + code);
                return code;
            } else if (row == realIndexOfRow) {
                for (int column = 0; column < initArray[row].length; column++) {
                    sumOfRow += initArray[row][column];
                }
                System.out.println("row is found. sum of row is " + sumOfRow);
                break;
            }
        }
        return sumOfRow;
    }

    /**
     * Вспомогательный метод для создания двумерного массива
     *
     * @return возвращает сформированный массив
     */
    public static int[][] getArray(int rows, int columns) {
        int[][] initialArray = new int[rows][columns];
        for (int i = 0; i < initialArray.length; i++) {
            for (int j = 0; j < initialArray[i].length; j++) {
                initialArray[i][j] = (int) (Math.random() * 10);
            }
        }
        return initialArray;
    }
}