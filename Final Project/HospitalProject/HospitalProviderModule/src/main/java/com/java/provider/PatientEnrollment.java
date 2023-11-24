package com.java.provider;

import java.util.Date;

public class PatientEnrollment {
	private String uhid;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private String userName;
	private String phoneNo;
	private String email;
	private String status;
	private String address;
	private String medHistory;
	
	
	public PatientEnrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientEnrollment(String uhid, String firstName, String lastName, Date dob, String gender, String userName,
			String phoneNo, String email, String status, String address, String medHistory) {
		super();
		this.uhid = uhid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.email = email;
		this.status = status;
		this.address = address;
		this.medHistory = medHistory;
	}
	@Override
	public String toString() {
		return "PatientEnrollment [uhid=" + uhid + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", userName=" + userName + ", phoneNo=" + phoneNo + ", email=" + email
				+ ", status=" + status + ", address=" + address + ", medHistory=" + medHistory + "]";
	}
	public String getUhid() {
		return uhid;
	}
	public void setUhid(String uhid) {
		this.uhid = uhid;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMedHistory() {
		return medHistory;
	}
	public void setMedHistory(String medHistory) {
		this.medHistory = medHistory;
	}
	  

}
