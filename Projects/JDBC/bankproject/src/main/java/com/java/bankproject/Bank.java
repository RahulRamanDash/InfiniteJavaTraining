package com.java.bankproject;

import java.sql.Date;

public class Bank {
	private int AccountNo;
	private String FirstName;
	private String LastName;
	private String City;
	private String State;
	private int Amount;
	private String CheqFacil;
	private String AccountType;
	private String Status;
	private Date DateOfOpen;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int accountNo, String firstName, String lastName, String city, String state, int amount,
			String cheqFacil, String accountType, String status, Date dateOfOpen) {
		super();
		AccountNo = accountNo;
		FirstName = firstName;
		LastName = lastName;
		City = city;
		State = state;
		Amount = amount;
		CheqFacil = cheqFacil;
		AccountType = accountType;
		Status = status;
		DateOfOpen = dateOfOpen;
	}

	@Override
	public String toString() {
		return "Bank [AccountNo=" + AccountNo + ", FirstName=" + FirstName + ", LastName=" + LastName + ", City=" + City
				+ ", State=" + State + ", Amount=" + Amount + ", CheqFacil=" + CheqFacil + ", AccountType="
				+ AccountType + ", Status=" + Status + ", DateOfOpen=" + DateOfOpen + "]";
	}

	public int getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getCheqFacil() {
		return CheqFacil;
	}

	public void setCheqFacil(String cheqFacil) {
		CheqFacil = cheqFacil;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getDateOfOpen() {
		return DateOfOpen;
	}

	public void setDateOfOpen(Date dateOfOpen) {
		DateOfOpen = dateOfOpen;
	}
	
}
