package ru.chernov.java.basic.homeworks.homework2;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        int[] integerArray = {5, 5, 7, 5, 5, 10};
        printMultipleStringByCount(5, "Эта строка будет много раз");
        sumArrayItemsGT5(integerArray);
        getFillingArray(112, new int[10]);
        upValueArrayItems(100, integerArray);
        getGreatHalfOfArray(integerArray);
        getSummaryArray(new int[]{1, 2, 3}, new int[]{4, -10}, new int[]{5, 7, 1, 3, 6});
        ifPointOfBalanceArray(new int[]{1, 1, 1, 1, 1, 5});
        checkAscByItems("desc", new int[]{1, 2, 3, -4, 5});
        reverseArray(new int[]{0, 5, 7, 2, 1, 10});
    }

    public static void printMultipleStringByCount(int cntRepeat, String initString) {
        int i;
        for (i = 1; i <= cntRepeat; i++) {
            System.out.println(initString);
        }
    }

    public static void sumArrayItemsGT5(int[] intArr) {
        int sumArrItems = 0;
        int i;
        for (i = 0; i < intArr.length; i++) {
            if (intArr[i] > 5) {
                sumArrItems += intArr[i];
            }
        }
        System.out.println(sumArrItems);
    }

    public static void getFillingArray(int intNumber, int... targetArr) {
        int i;
        for (i = 0; i < targetArr.length; i++) {
            targetArr[i] = intNumber;
        }
    }

    public static void upValueArrayItems(int upNum, int... targetArr) {
        int i;
        for (i = 0; i < targetArr.length; i++) {
            targetArr[i] += upNum;
        }
    }

    public static void getGreatHalfOfArray(int[] targetArr) {
        int sumHalf1 = 0;
        int sumHalf2 = 0;
        int i;
        for (i = 0; i < targetArr.length; i++) {
            if (i < targetArr.length / 2) {
                sumHalf1 += targetArr[i];
                //если количество элементов нечетное, то не суммируем центральный элемент
            } else if (targetArr.length % 2 != 0 && i == targetArr.length / 2) {
                sumHalf1 += 0;
            } else if (targetArr.length % 2 != 0 && i >= targetArr.length / 2) {
                sumHalf2 += targetArr[i];
            } else if (targetArr.length % 2 == 0 && i >= targetArr.length / 2) {
                sumHalf2 += targetArr[i];
            }
        }
        if (sumHalf1 > sumHalf2) {
            System.out.println("Сумма эл-ов первой половины массива больше, чем второй");
        } else if (sumHalf2 > sumHalf1) {
            System.out.println("Сумма эл-ов второй половины массива больше, чем первой");
        }
    }

    public static void getSummaryArray(int[] arr1, int[] arr2, int[] arr3) {
        byte i;
        int maxItemsArr = Math.max(arr1.length, Math.max(arr2.length, arr3.length));
        int[] summaryArr = new int[maxItemsArr];
        for (i = 0; i < arr1.length; i++) {
            summaryArr[i] += arr1[i];
        }
        for (i = 0; i < arr2.length; i++) {
            summaryArr[i] += arr2[i];
        }
        for (i = 0; i < arr3.length; i++) {
            summaryArr[i] += arr3[i];
        }
        System.out.println(Arrays.toString(summaryArr));
    }

    public static void ifPointOfBalanceArray(int[] checkArr) {
        int balancePoint;
        int sumItems = 0;
        int checkPoint = 0;
        for (int i = 0; i < checkArr.length; i++) {
            sumItems += checkArr[i];
        }
        if (sumItems % 2 == 0) {
            balancePoint = sumItems / 2;
            int i = 0;
            do {
                checkPoint += checkArr[i];
                i++;
            } while (checkPoint != balancePoint && i != checkArr.length);
            if (checkPoint == balancePoint) {
                System.out.println("Есть точка равновесия");
            } else {
                System.out.println("Точка равновесия отсутствует");
            }
        } else {
            System.out.println("Точка равновесия невозможна");
        }
    }

    public static void checkAscByItems(String order, int[] checkArr) {
        boolean saveOrder = false;
        if (order.equals("asc")) {
            for (int i = 0; i < checkArr.length - 1; i++) {
                if (checkArr[i + 1] >= checkArr[i]) {
                    saveOrder = true;
                } else {
                    saveOrder = false;
                    break;
                }
            }
        } else if (order.equals("desc")) {
            for (int i = checkArr.length - 1; i > 0; i--) {
                if (checkArr[i] >= checkArr[i - 1]) {
                    saveOrder = true;
                } else {
                    saveOrder = false;
                    break;
                }
            }
        }
        System.out.println(saveOrder);
    }

    public static void reverseArray(int[] initArray) {
        int[] reverseArray = new int[initArray.length];
        for (int i = 0; i < initArray.length; i++) {
            reverseArray[i] = initArray[initArray.length - 1 - i];
        }
        System.out.println("Reversed array is " + Arrays.toString(reverseArray));
    }
}