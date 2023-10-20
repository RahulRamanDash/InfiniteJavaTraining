package com.java.agent;

public class Agent {
	private int agentid;
	private String name;
	private String city;
	private Gender gender;
	private int maritalstatus;
	private double premium;
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agent(int agentid, String name, String city, Gender gender, int maritalstatus, double premium) {
		super();
		this.agentid = agentid;
		this.name = name;
		this.city = city;
		this.gender = gender;
		this.maritalstatus = maritalstatus;
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Agent [agentid=" + agentid + ", name=" + name + ", city=" + city + ", gender=" + gender
				+ ", maritalstatus=" + maritalstatus + ", premium=" + premium + "]";
	}
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(int maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}

	
	
}
