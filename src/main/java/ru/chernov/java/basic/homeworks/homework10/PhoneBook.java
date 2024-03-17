package ru.chernov.java.basic.homeworks.homework10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private String typePhoneBook;
    private Map<String, String> phoneNumberList;

    public PhoneBook(Map<String, String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
        phoneNumberList.put("Фамилия Имя", "79000000000");
    }

    public Map<String, String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void add(String name, String phoneNumber) {
        phoneNumberList.put(name, phoneNumber);
    }

    public void find(String name) {
        phoneNumberList.get(name);

    }

}
