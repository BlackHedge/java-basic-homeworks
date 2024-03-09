package ru.chernov.java.basic.homeworks.homework7;

import ru.chernov.java.basic.homeworks.homework7.Transport;

public class Human implements Movement {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean move(int distance, AreaType area) {
        if (currentTransport == null) {
            System.out.println("У " + name + " нет транспорта, поэтому идёт пешком " + distance);
            return true;
        }
        return currentTransport.move(distance, area);
    }

    public void takeTransport(Transport transport) {
        if (this.currentTransport == null) {
            this.currentTransport = transport;
            transport.setBusy(true);
            transport.setDriver(this);
            System.out.println(name + " использует " + currentTransport.getDescription());
        } else {
            currentTransport.setBusy(false);
            this.currentTransport = transport;
            transport.setBusy(true);
            transport.setDriver(this);
            System.out.println(name + " меняет транспорт на " + currentTransport.getDescription());
        }
    }

    public void takeOffTransport() {
        if (this.currentTransport != null) {
            currentTransport.setBusy(false);
            this.currentTransport = null;
            System.out.println(name + " больше не использует транспорт");
        }
    }
}