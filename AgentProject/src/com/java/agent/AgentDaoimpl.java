package com.java.agent;

import java.util.ArrayList;
import java.util.List;

public class AgentDaoimpl implements AgentDAO{
	
	static List<Agent> agentList;
	static{
		agentList = new ArrayList<Agent>();
	}

	@Override
	public List<Agent> showAgentDao() {
		return agentList;
	}

	 public int incrimentAgent() {
		if(agentList.size()==0){
			return 1;
		}
		else{
			return agentList.get(agentList.size()-1).getAgentId()+1;
		}
	}

	@Override
	public String addAgentDao(Agent agent) {
		System.out.println(agent);
		int id = incrimentAgent();
		agent.setAgentId(id);
		agentList.add(agent);
		System.out.println(agent);
		return "Agent is Added";
		
	}
	
	

}
