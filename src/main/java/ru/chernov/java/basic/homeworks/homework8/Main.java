package ru.chernov.java.basic.homeworks.homework8;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[][][] arrays = new String[][][]{
                {{"1", "3", "4", "5"}, {"10", "45", "123", "87"}, {"9", "34", "98", "3"}, {"54", "89", "2", "67"}},
                {{"1", "3", "4", "5"}, {"10", "45", "!23", "87"}, {"9", "34", "98", "3"}, {"54", "89", "2", "67"}},
                {{"1", "3", "4", "5"}, {"10", "45", "23", "87"}, {"9", "34", "98", "3"}, {"54", "89", "2", "67"}, {"0"}}
        };

        for (String[][] array : arrays) {
            System.out.println("Считается сумма элементов массива " + Arrays.deepToString(array));
            try {
                System.out.println("Cумма элементов массива " + sumSqrArrayItems(array));
            } catch (AppArraySizeException | AppArrayDataExeption e) {
                System.out.print("Сумма не посчитана: ");
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    /**
     * Метод принимает на вход строковый двумерный массив (4х4). Преобразует каждый элемент в число.
     * Если размерность массива не 4х4, то выбрасывается ошибка AppArraySizeException
     * Если невозможно преобразовать строку в число, выбрасывается ошибка AppArrayDatException
     *
     * @param array - двумерный (4х4) массив
     * @throws AppArraySizeException
     * @throws AppArrayDataExeption
     * @return Возвращает сумму всех элементов массива в числовом формате
     */
    public static int sumSqrArrayItems(String[][] array) throws AppArraySizeException, AppArrayDataExeption {
        Boolean isSquareSize = true;
        int sumOfArrayItems = 0;
        if (array.length != 4) {
            isSquareSize = false;
        }
        for (String[] item : array) {
            if (item.length != array.length) {
                isSquareSize = false;
                break;
            }
        }
        if (!isSquareSize) throw new AppArraySizeException("Размерность массива некорректная");
        for (int index1lvl = 0; index1lvl < 4; index1lvl++) {
            for (int index2lvl = 0; index2lvl < 4; index2lvl++) {
                try {
                    sumOfArrayItems = sumOfArrayItems + Integer.parseInt(array[index1lvl][index2lvl]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataExeption("Данные в ячейке " + index1lvl + "-" + index2lvl + " не " +
                            "содержит " +
                            "числового значения");
                }
            }
        }
        return sumOfArrayItems;
    }
}