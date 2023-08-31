package com.java.agent;

import java.io.IOException;
import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao();
	int incrimentAgent();
	String addAgentDao(Agent agent);
	Agent searchAgentDao(int empno);
	String deleteAgentDao(int empno);
	String updateAgentDao(Agent agentUpdated);
	String writeAgentFileDao() throws IOException;
	String ReadAgentFileDao() throws IOException, ClassNotFoundException;

}
