package ru.chernov.java.basic.homeworks.homework10;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook(new HashMap<>());
        pb.add("79000124321", "Gosha");
        pb.add("79889561871", "Simon");
        pb.add("79889561872", "Simon");
        pb.find("Simon");
        pb.find("Gosha");
        pb.find("Lola");
        System.out.println("Номер телефона содержится в справочнике? - " + pb.containsPhoneNumber("124"));
        System.out.println("Номер телефона содержится в справочнике? - " + pb.containsPhoneNumber("79000000000"));
    }
}