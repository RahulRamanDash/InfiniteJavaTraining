package com.java.agent;

import java.sql.SQLException;
import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao() throws SQLException, ClassNotFoundException;
	Agent searchAgentDao(int agentid);
	String addAgentDao(Agent agent);
	String deleteAgentDao(int empno);
	String updateAgentDao(Agent agent);
}