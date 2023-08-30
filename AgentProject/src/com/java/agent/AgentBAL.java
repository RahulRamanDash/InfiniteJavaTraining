package com.java.agent;

import java.util.List;

public class AgentBAL {
	static StringBuilder sb;
	static AgentDAO dao;
	static {
		dao = new AgentDaoimpl();
		sb = new StringBuilder();
	}

	public List<Agent> showAgentBal() {
		return dao.showAgentDao();
	}
	public String addAgentBal(Agent agent) throws AgentException {
		System.out.println(agent);
		if (validateAgent(agent)==true) {
			return dao.addAgentDao(agent);
		}
		throw new AgentException(sb.toString());
	}
	
	public boolean validateAgent(Agent agent) {
		boolean flag = true;
		if (agent.getFirstName().length() < 4 || agent.getLastName().length() < 4) {
			flag = false;
			sb.append("Name Contains min 4 characters...\r\n");
		}
		
		return flag;

}
	
}
