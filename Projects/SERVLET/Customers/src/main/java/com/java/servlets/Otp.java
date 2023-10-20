package com.java.servlets;

import java.sql.Date;

public class Otp {

	private int otpId;
	private String customerUserName;
	private String optCode;
	private Date generatedOn;
	public int getOtpId() {
		return otpId;
	}
	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getOptCode() {
		return optCode;
	}
	public void setOptCode(String optCode) {
		this.optCode = optCode;
	}
	public Date getGeneratedOn() {
		return generatedOn;
	}
	public void setGeneratedOn(Date generatedOn) {
		this.generatedOn = generatedOn;
	}
	public Otp(int otpId, String customerUserName, String optCode, Date generatedOn) {
		super();
		this.otpId = otpId;
		this.customerUserName = customerUserName;
		this.optCode = optCode;
		this.generatedOn = generatedOn;
	}
	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
