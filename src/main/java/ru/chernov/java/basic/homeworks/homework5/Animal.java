package ru.chernov.java.basic.homeworks.homework5;

import javax.xml.namespace.QName;

public class Animal {
    protected String name;
    private int runSpeed;
    protected int swimSpeed;
    private int stamina;
    private int factStamina;
    private byte staminaExpenseRun;
    protected byte staminaExpenseSwim;
    private String status;

    private final String TIRED = "устал";
    private final String FRESH = "свеж и весел";

    public Animal(String name, int runSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.stamina = stamina;
        this.staminaExpenseRun = 1;
        this.factStamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    public int getFactStamina() {
        return factStamina;
    }

    public String getStatus() {
        if (getFactStamina() > 0) {
            setStatus(FRESH);
        } else {
            setStatus(TIRED);
        }
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    /**
     * Метод изменяет уровень выносливости животного при изменениях.
     * Базовый уровень выносливости устанавливается статично в каждом подклассе.
     * Базовую выносливость изменить нельзя.
     *
     * @param stamina новый уровень текущей выносливости в у.е., целое число.
     *                Текущий уровень выносливости не может быть больше базового.
     */
    private void setFactStamina(int stamina) {
        if (stamina > this.stamina) {
            this.factStamina = this.stamina;
        }
        this.factStamina = stamina;
        System.out.println("Текущий уровень выносливости " + name + " изменился и теперь равен " + getFactStamina());
    }

    /**
     * Метод рассчитывает время прохождения указанной на дистанции с учетом доступной выносливости.
     * Сохраняет остаток выносливости и меняет статус животного, если выносливости исчерпана.
     *
     * @param distance заданная дистанция в метрах
     * @return возвращает время прохождения в секундах либо -1, если не хватило выносливости
     */
    public int run(int distance) {
        int time;
        System.out.println(name + " бежит дистанцию " + distance + " м");
        int needStamina = distance * staminaExpenseRun;
        int staminaRemain = getFactStamina();
        if (getFactStamina() < needStamina) {
            time = -1;
            setStatus(TIRED);
            staminaRemain = getFactStamina() - (distance / staminaExpenseRun);
            setFactStamina(staminaRemain);
            System.out.println(name + " " + getStatus() + ", не хватает выносливости, " +
                    "чтобы пройти дистанцию. Время: " + time);
            return time;
        } else {
            staminaRemain = getFactStamina() - (distance / staminaExpenseRun);
            time = distance / runSpeed;
            setFactStamina(staminaRemain);
            System.out.println(name + " " + getStatus() + " и успешно проходит дистанцию. Время: " + time + " сек");
            return time;
        }
    }

    /**
     * Метод рассчитывает время заплыва на указанной дистанции с учетом доступной выносливости.
     * Сохраняет остаток выносливости и меняет статус животного, если выносливости исчерпана.
     *
     * @param distance заданная дистанция в метрах
     * @return возвращает время прохождения в секундах либо -1, если не хватило выносливости
     */
    public int swim(int distance) {
        int time;
        System.out.println(name + " плывет дистанцию " + distance + " м");
        int needStamina = distance * staminaExpenseSwim;
        int staminaRemain = getFactStamina();
        if (getFactStamina() < needStamina) {
            time = -1;
            setStatus(TIRED);
            staminaRemain = getFactStamina() - (distance / staminaExpenseSwim);
            setFactStamina(staminaRemain);
            System.out.println(name + " " + getStatus() + ", не хватает выносливости, " +
                    "чтобы проплыть дистанцию. Время: " + time);
            return time;
        } else {
            staminaRemain = getFactStamina() - (distance / staminaExpenseSwim);
            time = distance / swimSpeed;
            setFactStamina(staminaRemain);
            System.out.println(name + " " + getStatus() + " и это успешный заплыв. Время: " + time + " сек");
            return time;
        }
    }

    /**
     * Метод выводит в консоль информацию о состоянии животного и уровни оставшейся и максимальной выносливости
     */
    public void info() {
        System.out.println("Состояние " + name + ": " + status);
        System.out.println("Уровень выносливости у " + name + ": "
                + getFactStamina() + " из " + getStamina() + " у.е.");
    }
}
