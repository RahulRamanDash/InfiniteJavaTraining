package com.java.agent;

public class Agent {

	private int agentId;
	private String firstName;
	private String lastName;
	private String city;
	private PayMode payMode;
	
	
	public Agent() {
		super();
	}
	public Agent(int agentId, String firstName, String lastName, String city,
			PayMode payMode) {
		super();
		this.agentId = agentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.payMode = payMode;
	}
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + ", payMode="
				+ payMode + "]";
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


	
}