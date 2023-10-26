package com.java.hib;

public class InsurancePlan {
    private int planId;
    private int insuranceId;
    private double premiumAmount;
    private double coverageAmount;

    // Constructors
    public InsurancePlan() {
        // Default constructor
    }

    public InsurancePlan(int planId, int insuranceId, double premiumAmount, double coverageAmount) {
        this.planId = planId;
        this.insuranceId = insuranceId;
        this.premiumAmount = premiumAmount;
        this.coverageAmount = coverageAmount;
    }

    // Getters and Setters
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    @Override
    public String toString() {
        return "InsurancePlan{" +
                "planId=" + planId +
                ", insuranceId=" + insuranceId +
                ", premiumAmount=" + premiumAmount +
                ", coverageAmount=" + coverageAmount +
                '}';
    }
}
