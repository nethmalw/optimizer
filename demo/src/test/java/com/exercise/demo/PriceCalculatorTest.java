package com.exercise.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTest {

    @Test
    @DisplayName("Optimal Cartons and Units")
    void getCartonsAndUnits() {
        int[] totalUnits = {289, 0, -1, 15};
        int[] cartonSize = {20, 0, 12, -2};

        int[] expectedCartons = {14, 0, 0, 0};
        int[] expectedUnits = {9, 0, 0, 0};

        // Get optimized no of Cartons and Single Units
        CategorizedUnits first = PriceCalculator.getCartonsAndUnits(totalUnits[0], cartonSize[0]);
        CategorizedUnits second = PriceCalculator.getCartonsAndUnits(totalUnits[1], cartonSize[1]);
        CategorizedUnits third = PriceCalculator.getCartonsAndUnits(totalUnits[2], cartonSize[2]);
        CategorizedUnits fourth = PriceCalculator.getCartonsAndUnits(totalUnits[3], cartonSize[3]);

        int[] actualCartons = {first.getCartons(), second.getCartons(), third.getCartons(), fourth.getCartons()};
        int[] actualUnits = {first.getUnits(), second.getUnits(), third.getUnits(), fourth.getUnits()};

        assertArrayEquals(expectedCartons, actualCartons);
        assertArrayEquals(expectedUnits, actualUnits);

    }

    @Test
    @DisplayName("Total Price")
    void getTotalPrice() {
        int[] totalUnits = {289, 0, -1, 15};
        int[] cartonSize = {20, 0, 12, -2};
        double[] cartonPrice = {175, 23, -2, -9};
        double[] expected = {2297.1375, 0, -1, -1};

        // Get optimized no of Cartons and Single Units
        CategorizedUnits first = PriceCalculator.getCartonsAndUnits(totalUnits[0], cartonSize[0]);
        CategorizedUnits second = PriceCalculator.getCartonsAndUnits(totalUnits[1], cartonSize[1]);
        CategorizedUnits third = PriceCalculator.getCartonsAndUnits(totalUnits[2], cartonSize[2]);
        CategorizedUnits fourth = PriceCalculator.getCartonsAndUnits(totalUnits[3], cartonSize[3]);

        // Get Total Price for each instance
        double firstTotal = PriceCalculator.getTotalPrice(first, cartonPrice[0], cartonSize[0]);
        double secondTotal = PriceCalculator.getTotalPrice(second, cartonPrice[1], cartonSize[0]);
        double thirdTotal = PriceCalculator.getTotalPrice(third, cartonPrice[2], cartonSize[0]);
        double fourthTotal = PriceCalculator.getTotalPrice(fourth, cartonPrice[3], cartonSize[0]);

        double[] actual = {firstTotal, secondTotal, thirdTotal, fourthTotal};

        assertArrayEquals(expected, actual);

    }

    @Test
    @DisplayName("Unit Price")
    void getUnitPrice() {
        double[] cartonPrice = {175, 23, -2, -9};
        int[] cartonSize = {20, 0, 12, -2};
        double[] expected = {11.375, -1, -1, -1};

        //Get Unit Price for each instance
        double first = PriceCalculator.getUnitPrice(cartonPrice[0], cartonSize[0]);
        double second = PriceCalculator.getUnitPrice(cartonPrice[1], cartonSize[1]);
        double third = PriceCalculator.getUnitPrice(cartonPrice[2], cartonSize[2]);
        double fourth = PriceCalculator.getUnitPrice(cartonPrice[3], cartonSize[3]);

        double[] actual = {first,second,third,fourth};

        assertArrayEquals(expected, actual);
    }
}
