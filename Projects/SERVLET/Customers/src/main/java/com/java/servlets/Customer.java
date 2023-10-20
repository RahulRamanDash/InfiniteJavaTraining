package com.java.servlets;

import java.util.Date;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String phoneNo;
	
	private String status;
	private Date activatedOn;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getActivatedOn() {
		return activatedOn;
	}
	public void setActivatedOn(Date activatedOn) {
		this.activatedOn = activatedOn;
	}
	public Customer(int customerId, String firstName, String lastName, String userName, String password, String email,
			String phoneNo, String status, Date activatedOn) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.status = status;
		this.activatedOn = activatedOn;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
