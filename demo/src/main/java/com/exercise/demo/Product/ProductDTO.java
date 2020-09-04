package com.exercise.demo.Product;

public class ProductDTO {
    private int productId;
    private String productName;
    private double cartonPrice;
    private int cartonSize;
    private double unitPrice;

    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName, double cartonPrice, int cartonSize, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.cartonPrice = cartonPrice;
        this.cartonSize = cartonSize;
        this.unitPrice = unitPrice;
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

    public double getCartonPrice() {
        return cartonPrice;
    }


    public int getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(int cartonSize) {
        this.cartonSize = cartonSize;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
