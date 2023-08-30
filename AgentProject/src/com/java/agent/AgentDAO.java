package com.java.agent;

import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao();
	int incrimentAgent();
	String addAgentDao(Agent agent);
	

}
