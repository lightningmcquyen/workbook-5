package com.pluralsight.dealership;

public class LeaseContract extends Contract {
    private double leasePrice;
    private int leaseTerm; // (months)

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double leasePrice, int leaseTerm) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.leasePrice = leasePrice;
        this.leaseTerm = leaseTerm;
    }

    public double getLeasePrice() {
        return leasePrice;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    @Override
    public double getTotalPrice() {
        return leasePrice * leaseTerm; // Total price over the lease term
    }

    @Override
    public double getMonthlyPayment() {
        return leasePrice; // Monthly payment is the lease price
    }
}