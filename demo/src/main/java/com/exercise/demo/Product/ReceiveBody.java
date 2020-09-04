package com.exercise.demo.Product;


class ReceiveBody {
    private int productId;
    private int noOfCartons;
    private int noOfUnits;

    public ReceiveBody(int productId, int noOfCartons, int noOfUnits) {
        this.productId = productId;
        this.noOfCartons = noOfCartons;
        this.noOfUnits = noOfUnits;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
