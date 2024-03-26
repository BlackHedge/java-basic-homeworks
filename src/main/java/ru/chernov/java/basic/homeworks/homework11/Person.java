package ru.chernov.java.basic.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private Long id;
    private String name;
    private Position position;

    public Person(Long id, String name, Position position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Long, String> convertPerson(Long id, String name) {
        Map<Long, String> map = new HashMap<>();
        return map;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", position=" + position + '}';
    }
}