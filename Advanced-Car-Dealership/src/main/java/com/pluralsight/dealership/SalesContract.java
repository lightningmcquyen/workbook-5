package com.pluralsight.dealership;

public class SalesContract extends Contract {
    private double salePrice; // Base price of the vehicle
    private double salesTax; // Sales tax amount
    private double recordingFee; // Recording fee
    private double processingFee; // Processing fee
    private boolean finance; // Whether the buyer wants to finance

    // Constructor
    public SalesContract(String dateOfContract, String customerName, String customerEmail,
                         Vehicle vehicleSold, double salePrice, boolean finance) {
        super(dateOfContract, customerName, customerEmail, vehicleSold); // Pass all required parameters to Contract
        this.salePrice = salePrice;
        this.finance = finance;
        this.salesTax = calculateSalesTax(salePrice);
        this.recordingFee = 100; // Fixed recording fee
        this.processingFee = calculateProcessingFee(salePrice);
    }

    // Calculate sales tax (5%)
    private double calculateSalesTax(double salePrice) {
        return salePrice * 0.05;
    }

    // Calculate processing fee based on vehicle price
    private double calculateProcessingFee(double salePrice) {
        if (salePrice < 10000) {
            return 295; // Fee for vehicles under $10,000
        } else {
            return 495; // Fee for vehicles $10,000 and above
        }
    }

    // Getters and Setters
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }



    // Override getTotalPrice to calculate total
    @Override
    public double getTotalPrice() {
        return salePrice + salesTax + recordingFee + processingFee;
    }

    // Override getMonthlyPayment based on financing options
    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0; // No financing means no monthly payment
        }
        double totalPrice = getTotalPrice();
        double monthlyPayment = 0;

        // Determine the loan terms
        if (salePrice >= 10000) {
            double interestRate = 0.0425; // 4.25% interest
            monthlyPayment = (totalPrice * (interestRate / 12)) /
                    (1 - Math.pow(1 + (interestRate / 12), -48));
        } else {
            double interestRate = 0.0525; // 5.25% interest
            monthlyPayment = (totalPrice * (interestRate / 12)) /
                    (1 - Math.pow(1 + (interestRate / 12), -24));
        }
        return monthlyPayment; // Return calculated monthly payment
    }
}