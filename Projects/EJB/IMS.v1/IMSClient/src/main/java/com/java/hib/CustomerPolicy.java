package com.java.hib;

import java.util.Date;

public class CustomerPolicy {
    private int policyId;
    private int custId;
    private int insuranceId;
    private int planId;
    private double insuranceAmount;
    private PayMode payMode;
    private double initialAmount;
    private Date registerDate;
    
    
	public CustomerPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerPolicy(int policyId, int custId, int insuranceId, int planId, double insuranceAmount,
			PayMode payMode, double initialAmount, Date registerDate) {
		super();
		this.policyId = policyId;
		this.custId = custId;
		this.insuranceId = insuranceId;
		this.planId = planId;
		this.insuranceAmount = insuranceAmount;
		this.payMode = payMode;
		this.initialAmount = initialAmount;
		this.registerDate = registerDate;
	}



	

	
	@Override
	public String toString() {
		return "CustomerPolicy [policyId=" + policyId + ", custId=" + custId + ", insuranceId=" + insuranceId
				+ ", planId=" + planId + ", insuranceAmount=" + insuranceAmount + ", payMode=" + payMode
				+ ", initialAmount=" + initialAmount + ", registerDate=" + registerDate + "]";
	}

	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public double getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
    public PayMode getPayMode() {
        return payMode;
    }
    public void setPayMode(PayMode payMode) {
        this.payMode = payMode;
    }
	public double getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
    
    
}
