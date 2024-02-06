package ru.chernov.java.basic.homeworks.homework4;

import java.time.Year;

public class MainApplication {
    public static void main(String[] args) {
        User[] users =
                {
                        new User("Иванов", "Иван", "Иванович", 1960, "user1@email.com"),
                        new User("Петров", "Федор", "Лукич", 2000, "нет"),
                        new User("Сидоров", "Дмитрий", "Борисович", 2020, "abrikos-sobaka@mm.ru "),
                        new User("Лазарев", "Алексей", "Саныч", 1966, "sunych@mail.ru"),
                        new User("Безымянный", "Максим", "Максимыч", 1980, "nonamefactory@infomail.com"),
                        new User("Опасный", "Александр", "Сергеевич", 1990, "mailmailmail@mail.com"),
                        new User("Чурбанов", "Кирилл", "Сергеевич", 1995, "cks1995@mail.ru"),
                        new User("Баранов", "Сергей", "Иванович", 1999, "bosya2009@yandex.ru"),
                        new User("Иглова", "Галина", "Рамазановна", 2001, "mainman@gmail.com"),
                        new User("Чудаков", "Илья", "", 2003, "нет")
                };
        int currentYear = Year.now().getValue();
        for (int userId = 0; userId < users.length; userId++) {
            if ((currentYear - users[userId].getBirthYear()) >= 40) {
                System.out.println("Запись № " + (userId + 1));
                users[userId].info();
            }
        }
        Box postBox = new Box("L", "white");
        postBox.fullInfoBox();
        postBox.putItem("lego");
        postBox.open();
        postBox.putItem("book");
        postBox.open();
        postBox.getContent();
        postBox.removeItem("lego");
        postBox.removeItem("book");
        postBox.close();
        postBox.repaint("green");
        postBox.fullInfoBox();
    }
}