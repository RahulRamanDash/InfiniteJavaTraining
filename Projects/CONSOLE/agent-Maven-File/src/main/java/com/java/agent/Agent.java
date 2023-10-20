package com.java.agent;

import java.io.Serializable;

public class Agent implements Serializable{

	private int agentId;
	private String firstName;
	private String lastName;
	private String city;
	private PayMode payMode;
	private double premium;
	
	
	public Agent() {
		super();
	}
	
	public Agent(int agentId, String firstName, String lastName, String city,
			PayMode payMode, double premium) {
		super();
		this.agentId = agentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.payMode = payMode;
		this.premium = premium;
	}

	
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + ", payMode="
				+ payMode + ", premium=" + premium + "]";
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PayMode getPayMode() {
		return payMode;
	}

	public void setPayMode(PayMode payMode) {
		this.payMode = payMode;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	


	
}