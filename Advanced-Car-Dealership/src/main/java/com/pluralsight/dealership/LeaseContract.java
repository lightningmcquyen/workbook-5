package com.pluralsight.dealership;

public class LeaseContract {
    private int vin;
    private String lesseeName;
    private double leasePrice;
    private int leaseTerm; // in months

    public LeaseContract(int vin, String lesseeName, double leasePrice, int leaseTerm) {
        this.vin = vin;
        this.lesseeName = lesseeName;
        this.leasePrice = leasePrice;
        this.leaseTerm = leaseTerm;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getLesseeName() {
        return lesseeName;
    }

    public void setLesseeName(String lesseeName) {
        this.lesseeName = lesseeName;
    }

    public double getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(double leasePrice) {
        this.leasePrice = leasePrice;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    // toString() method for display
}

