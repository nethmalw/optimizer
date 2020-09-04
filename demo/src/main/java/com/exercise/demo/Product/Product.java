package com.exercise.demo.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_prices")
public class Product {

    @Id
    private int productId;
    @Column
    private String productName;
    @Column
    private double cartonPrice;
    @Column
    private int cartonSize;

    public Product(){}

    public Product(int productId, String productName, double cartonPrice, int cartonSize) {
        this.productId = productId;
        this.productName = productName;
        this.cartonPrice = cartonPrice;
        this.cartonSize = cartonSize;
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

    public void setCartonPrice(int cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public int getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(int cartonSize) {
        this.cartonSize = cartonSize;
    }
}
