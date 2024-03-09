package ru.chernov.java.basic.homeworks.homework7;

public enum AreaType {
    FOREST("Лес"),
    SWAMP("Болото"),
    PLAIN("Равнина");

    private String areaTypeName;

    public String getAreaTypeName() {
        return areaTypeName;
    }

    AreaType(String areaTypeName) {
        this.areaTypeName = areaTypeName;
    }
}