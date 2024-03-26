package ru.chernov.java.basic.homeworks.homework11;

import java.util.*;

public class PersonDataBase {
    private Map<Long, Person> listPerson;

    public PersonDataBase() {
        this.listPerson = new HashMap<>();
    }

    public Person findById(Long id) {
        return listPerson.get(id);
    }

    public void add(Person person) {
        listPerson.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        return person.getPosition().getTypePosition().equals("manager");
    }

    public boolean isEmployee(Long id) {
        return !this.findById(id).getPosition().getTypePosition().equals("manager");
    }
}