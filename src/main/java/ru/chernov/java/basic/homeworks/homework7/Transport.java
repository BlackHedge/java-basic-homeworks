package ru.chernov.java.basic.homeworks.homework7;

public class Transport implements Movement {
    private String description;
    private boolean isBusy;
    private Human driver;

    public Transport(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public String getDriverName() {
        return driver.getName();
    }

    public void setDriver(Human driver) {
        this.driver = driver;
    }

    public void setBusy(boolean busy) {
        if (!busy) this.driver = null;
        isBusy = busy;
    }

    @Override
    public boolean move(int distance, AreaType area) {
        return true;
    }
}