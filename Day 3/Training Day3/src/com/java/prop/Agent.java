package com.java.prop;

public class Agent {
	private int agntId;
	private String agentName;
	private double premium;
	public void setAgntId(int agntId) {
		this.agntId = agntId;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public void setpremium(double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Agent [agntId=" + agntId + ", agentName=" + agentName
				+ ", premium=" + premium + "]";
	}
	

}
