package com.exercise.demo;

public class PriceCalculator {

    // Used for obtaining the optimized no of Cartons and Individual Units
    public static CategorizedUnits getCartonsAndUnits(int totalUnits, int cartonSize) {
        if (totalUnits >= 0 && cartonSize > 0) {
            CategorizedUnits categorized = new CategorizedUnits();

            categorized.setCartons(totalUnits / cartonSize);
            categorized.setUnits(totalUnits % cartonSize);

            return categorized;
        } else
            return new CategorizedUnits(0,0);
    }

    // Used for obtaining the total optimized price
    public static double getTotalPrice(CategorizedUnits categorizedUnits, double cartonPrice, int cartonSize) {
        if (cartonPrice >= 0 && cartonSize > 0) {
            if (categorizedUnits.getCartons() >= 3) {
                //Discount of 10%
                cartonPrice = cartonPrice * (9.0 / 10.0);
            }

            double unitPrice = getUnitPrice(cartonPrice, cartonSize);
            double totalPrice = (categorizedUnits.getCartons() * cartonPrice) + (categorizedUnits.getUnits() * unitPrice);

            return totalPrice;
        } else
            return -1;

    }

    // Used for obtaining a single unit price
    public static double getUnitPrice(double cartonPrice, int cartonSize) {
        if (cartonPrice >= 0 && cartonSize > 0) {
            return (cartonPrice * (13.0 / 10.0)) / cartonSize;
        } else
            return -1;

    }

}
