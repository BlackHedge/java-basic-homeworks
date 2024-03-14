package ru.chernov.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ДЗ 9. OTUS. Java Basic. Коллекции. Часть 1
 *
 * @author студент Максим Чернов
 */
public class Main {
    public static void main(String[] args) {
        ArrayList numberList = new ArrayList<>();
        try {
            numberList = getSequenceBetween(-10, 10);
            System.out.println(getSequenceBetween(-10, -11));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sumOfList(numberList));
        ArrayList<Integer> targetList = new ArrayList<>(Arrays.asList(34, 67876, 34, null, 4, null));
        System.out.println("Исходный список " + targetList.toString());
        System.out.println("Список с заменой " + substituteInList(targetList, 4).toString());
        System.out.println("Исходный список " + targetList.toString());
        System.out.println("Список с увеличением " + increaseNumberInList(targetList, 6).toString());
        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Кеша", 35),
                new Employee("Саныч", 44),
                new Employee("Ольга", 30),
                new Employee("Геннадий", 48),
                new Employee("Светлана Васильевна Полудуб", 73)));
        System.out.println("Список имен сотрудников" + getEmployeesListName(employees));
        System.out.println("Список сотрудников старше 35-ти:");
        for (Employee employee : getEmployeesByAge(employees, 45)) {
            System.out.println(employee.getName() + ", " + employee.getAge());
        }
        System.out.println("Средний возраст сотрудников больше 30 - " + checkAverageEmployeesAge(employees, 30));
        System.out.println("Самый молодой сотрудник: " + getYoungestEmployee(employees).getName() + ", " +
                getYoungestEmployee(employees).getAge() + " лет");
    }

    /**
     * Метод принимает на вход два целочисленных значения и формирует список целочисленных значений между ними с
     * шагом 1 (единица)
     *
     * @param min минимальное целое число диапазон
     * @param max максимальное целое число диапазона
     * @return возвращает последовательность чисел между полученными, включая их самих
     * @throws Exception возникает в случае, если максимальное значение меньше минимального
     */
    public static ArrayList getSequenceBetween(int min, int max) throws Exception {
        if (min > max) {
            throw new Exception("Максимальное значение не может быть меньше минимального");
        }
        ArrayList<Integer> sequenceNumber = new ArrayList<>(max - min + 1);
        for (int item = min; item <= max; item++) {
            sequenceNumber.add(item);
        }
        return sequenceNumber;
    }

    /**
     * Метод получает на вход список целых чисел и считает их сумму
     *
     * @param numberList список целых чисел
     * @return sum - сумма всех значений полученного списка
     */
    public static int sumOfList(ArrayList<Integer> numberList) {
        int sum = 0;
        for (Integer item : numberList) {
            sum = (item > 5) ? sum + item : sum;
        }
        return sum;
    }

    /**
     * Метод заменяет все непустые (not null) значения в списке на указанный в аргументе.
     * Пустые (null) значения остаются без изменений
     *
     * @param targetList входящий список целых чисел
     * @param number     число для подстановки
     * @return возвращает измененный входящий список
     */
    public static ArrayList substituteInList(ArrayList<Integer> targetList, int number) {
        for (int i = 0; i < targetList.size(); i++) {
            if ((targetList.get(i) != null)) {
                targetList.set(i, number);
            }
        }
        return targetList;
    }

    /**
     * Метод увеличивает каждое не пустое (not null) значение входящего списка на указанное целое число.
     * Если элемент списка пустой (null), то рассматривается как ноль и увеличивается на указанное целое число.
     *
     * @param targetList входящий список целых чисел
     * @param number     число, на которое увеличивается
     * @return возвращает измененный входящий список
     */
    public static ArrayList increaseNumberInList(ArrayList<Integer> targetList, int number) {
        for (int i = 0; i < targetList.size(); i++) {
            if ((targetList.get(i) != null)) {
                targetList.set(i, targetList.get(i) + number);
            } else {
                targetList.set(i, number);
            }
        }
        return targetList;
    }

    /**
     * Метод формирует список имен сотрудников из полученного списка.
     *
     * @param employees список сотрудников
     * @return возвращает список имен исходного списка сотрудников
     */
    public static ArrayList<String> getEmployeesListName(ArrayList<Employee> employees) {
        ArrayList<String> employeeNames = new ArrayList<>();
        for (Employee employee : employees) {
            employeeNames.add(employee.getName());
        }
        return employeeNames;
    }

    /**
     * Метод представляет выборку сотрудников их списка, которые соответствуют или старше указанного возраста.
     *
     * @param employees список сотрудников
     * @param minAge    минимальный оцениваемый возраст
     * @return возвращает список сотрудников подходящего возраста
     */
    public static ArrayList<Employee> getEmployeesByAge(ArrayList<Employee> employees, int minAge) {
        ArrayList<Employee> employeesRateAge = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                employeesRateAge.add(employee);
            }
        }
        return employeesRateAge;
    }

    /**
     * Метод проверяет, является ли средний возраст всех сотрудников выше минимально допустимого среднего возраста.
     *
     * @param employees список сотрудников
     * @param avgAge    целевой средний возраст
     * @return возвращает true если средний возраст выше или равен целевому среднему возрасту и false в противном случае
     */
    public static boolean checkAverageEmployeesAge(ArrayList<Employee> employees, int avgAge) {
        int avgAgeOfEmployees = 0;
        for (Employee employee : employees) {
            avgAgeOfEmployees = avgAgeOfEmployees + employee.getAge();
        }
        avgAgeOfEmployees = (int) (avgAgeOfEmployees / employees.size());
        System.out.println("Средний возраст сотрудников - " + avgAgeOfEmployees);
        if (avgAgeOfEmployees >= avgAge) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод определяет самого младшего по возрасту сотрудника из полученного списка
     *
     * @param employees входящий список сотрудников
     * @return возвращает Employee с самым меньшим возрастом из полученного списка. Если под условия подходит
     * несколько, то возвращается первый
     */
    public static Employee getYoungestEmployee(ArrayList<Employee> employees) {
        Employee youngEmployee = employees.get(0);
        for (Employee employee : employees) {
            youngEmployee = (employee.getAge() < youngEmployee.getAge()) ? employee : youngEmployee;
        }
        return youngEmployee;
    }
}