package ru.chernov.java.basic.homeworks.homework6;

public class Plate {
    private int maxAmountFood;
    private int currentAmountFood;

    public Plate(int maxAmountFood) {
        this.maxAmountFood = maxAmountFood;
        this.currentAmountFood = maxAmountFood;
    }

    private int getMaxAmountFood() {
        return maxAmountFood;
    }

    public int getCurrentAmountFood() {
        return currentAmountFood;
    }

    public void addFood(int foodPortion) {
        currentAmountFood = Math.min((currentAmountFood + foodPortion), maxAmountFood);
    }

    public boolean decreaseFood(int foodPortion) {
        if ((currentAmountFood - foodPortion) < 0) return false;
        currentAmountFood = currentAmountFood - foodPortion;
        return true;
    }
}
