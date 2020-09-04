package com.exercise.demo;

public class CategorizedUnits {

    private int cartons;
    private int units;

    public CategorizedUnits(){}

    public CategorizedUnits(int cartons, int units) {
        this.cartons = cartons;
        this.units = units;
    }

    public int getCartons() {
        return cartons;
    }

    public void setCartons(int cartons) {
        this.cartons = cartons;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
