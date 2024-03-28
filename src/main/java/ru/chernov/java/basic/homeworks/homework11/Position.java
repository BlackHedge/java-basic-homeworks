package ru.chernov.java.basic.homeworks.homework11;

public enum Position {
    MANAGER("manager"),
    DIRECTOR("manager"),
    DRIVER("employee"),
    ENGINEER("employee"),
    SENIOR_MANAGER("manager"),
    DEVELOPER("employee"),
    QA("employee"),
    JANITOR("employee"),
    PLUMBER("employee"),
    BRANCH_DIRECTOR("manager"),
    JUNIOR_DEVELOPER("employee");

    private String typePosition;

    Position(String typePosition) {
        this.typePosition = typePosition;
    }

    public String getTypePosition() {
        return this.typePosition;
    }
}