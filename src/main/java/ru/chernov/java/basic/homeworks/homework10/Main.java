package ru.chernov.java.basic.homeworks.homework10;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook(new HashMap<>());
        pb.add("Igor", "79001234567");
        pb.add("Igor", "3765743");
        pb.add("Igor", "hfg");
        pb.add("Igor", "yjvth");
        pb.find("Igor");

    }
}
