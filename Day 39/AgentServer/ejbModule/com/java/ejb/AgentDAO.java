package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	Agent searchAgentDao(int agentid) throws ClassNotFoundException, SQLException;
	String addAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
	String deleteAgentDao(int agentid) throws ClassNotFoundException, SQLException;
	String updateAgentDao(Agent agent) throws ClassNotFoundException, SQLException;
}
