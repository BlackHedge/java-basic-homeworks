package ru.chernov.java.basic.homeworks.homework10;

import java.util.*;

public class PhoneBook {
    private Map<String, String> phoneNumberList;

    public PhoneBook() {
        this.phoneNumberList = new HashMap<>();
    }

    public Map<String, String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void add(String phoneNumber, String name) {
        phoneNumberList.put(phoneNumber, name);
    }

    public void find(String name) {
        System.out.println("Поиск номера телефона по имени " + name + "...");
        int cntFound = 0;
        if (phoneNumberList.containsValue(name)) {
            for (Map.Entry<String, String> entry : phoneNumberList.entrySet()) {
                if (entry.getValue().equals(name)) {
                    System.out.println("* " + entry.getKey());
                    cntFound++;
                }
            }
        } else {
            System.out.println("Указанное имя отсутствует в справочнике");
        }
        System.out.println("Поиск завершен. Найдено номеров: " + cntFound + ".");
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return phoneNumberList.containsKey(phoneNumber);
    }
}