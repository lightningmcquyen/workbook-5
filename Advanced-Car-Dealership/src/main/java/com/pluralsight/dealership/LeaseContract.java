package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private double expectedEndingValue; // 50% of the original price
    private double leaseFee; // 7% of the original price
    private boolean financed; // Indicates if the lease is financed

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle, double originalPrice, boolean financed) {
        super(dateOfContract, customerName, customerEmail, vehicle); // Call the constructor of the parent class
        this.expectedEndingValue = originalPrice * 0.5; // Calculate expected ending value
        this.leaseFee = originalPrice * 0.07; // Calculate lease fee
        // Additional calculations can be performed based on your requirements
    }

    public boolean isFinanced() {
        return financed; // Getter for financed status
    }

    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee; // Total price for the lease contract
    }

    @Override
    public double getMonthlyPayment() {
        double monthlyPayment = 0.0; // Default value if no financing
        if (isFinanced()) { // Check if financed
            // Calculate monthly payment based on lease conditions
            monthlyPayment = (getTotalPrice() / 36); // Simple monthly payment calculation for a 36-month lease
        }
        return monthlyPayment;
    }
}