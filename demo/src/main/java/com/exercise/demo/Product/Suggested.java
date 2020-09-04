package com.exercise.demo.Product;

public class Suggested {
    private int productId;
    private String productName;
    private int noOfCartons;
    private int noOfUnits;
    private double totalPrice;

    public Suggested(){}

    public Suggested(int productId, String productName, int noOfCartons, int noOfUnits, double totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.noOfCartons = noOfCartons;
        this.noOfUnits = noOfUnits;
        this.totalPrice = totalPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNoOfCartons() {
        return noOfCartons;
    }

    public void setNoOfCartons(int noOfCartons) {
        this.noOfCartons = noOfCartons;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
