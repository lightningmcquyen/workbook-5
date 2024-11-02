package com.pluralsight.dealership;

public class SalesContract extends Contract {
    private double salePrice;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double salePrice) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salePrice = salePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    @Override
    public double getTotalPrice() {
        return salePrice; // For a sale, the total price is the sale price
    }

    @Override
    public double getMonthlyPayment() {
        return 0; // No monthly payment for a sale
    }
}