package com.java.hib;

import java.util.Date;

public class CustomerDetails {
	  	private int custId;
	    private String firstName;
	    private String lastName;
	    private Gender gender;
	    private Date dateOfBirth;
	    private String userName;
	    private String email;
	    private String passCode;
	    private Status status;
	    private int admin;
	    
		public CustomerDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CustomerDetails(int custId, String firstName, String lastName, Gender gender, Date dateOfBirth,
				String userName, String email, String passCode, Status status, int admin) {
			super();
			this.custId = custId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.userName = userName;
			this.email = email;
			this.passCode = passCode;
			this.status = status;
			this.admin = admin;
		}




		@Override
		public String toString() {
			return "CustomerDetails [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", userName=" + userName + ", email="
					+ email + ", passCode=" + passCode + ", status=" + status + ", admin=" + admin + "]";
		}




		public int getCustId() {
			return custId;
		}
		public void setCustId(int custId) {
			this.custId = custId;
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
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassCode() {
			return passCode;
		}
		public void setPassCode(String passCode) {
			this.passCode = passCode;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}

		public int getAdmin() {
			return admin;
		}

		public void setAdmin(int admin) {
			this.admin = admin;
		}
	    
	    
}
