package com.java.jsf;

public class Login {
	private String userName;
	private String passCode;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String userName, String passCode) {
		super();
		this.userName = userName;
		this.passCode = passCode;
	}
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", passCode=" + passCode + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassCode() {
		return passCode;
	}
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}
	
	

}
