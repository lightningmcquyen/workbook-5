package com.pluralsight.dealership;

public class SalesContract {
    private int vin;
    private String buyerName;
    private double salePrice;

    public SalesContract(int vin, String buyerName, double salePrice) {
        this.vin = vin;
        this.buyerName = buyerName;
        this.salePrice = salePrice;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    // toString() method for display
}

