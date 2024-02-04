package ru.chernov.java.basic.homeworks.homework4;

public class User {
    private String name;
    private String surname;
    private String thirdName;
    private int birthYear;
    private String email;

    public User(String name, String surname, String thirdName, int birthYear, String email) {
        this.name = name;
        this.surname = surname;
        this.thirdName = thirdName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void info() {
        System.out.println("* -Информация о пользователе- *");
        System.out.println("ФИО: " + surname + " " + name + " " + thirdName);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
        System.out.println("------------");
    }

}
