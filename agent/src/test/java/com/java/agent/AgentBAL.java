package com.java.agent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class AgentBAL {
	static StringBuilder sb;
	static AgentDAO dao;
	static {
		dao = new AgentDaoimpl();
		sb = new StringBuilder();
	}

	public String ReadAgentFileBal() throws IOException, ClassNotFoundException{
		return dao.ReadAgentFileDao();
	}
	public String writeAgentFileBal() throws FileNotFoundException, IOException{
		return dao.writeAgentFileDao();
	}
	
	public String updateAgentBal(Agent agentUpdated) throws Exception{
		if(validateAgent(agentUpdated)==true){
			return dao.updateAgentDao(agentUpdated);
		}
		//check Leter
		throw new AgentException(sb.toString());
	}
	
	public String deleAgentBal(int agentno){
		return dao.deleteAgentDao(agentno);
	}
	
	public Agent searchAgentBal(int agentno){
		return dao.searchAgentDao(agentno);
	}
	
	public List<Agent> showAgentBal() {
		return dao.showAgentDao();
	}
	public String addAgentBal(Agent agent) throws AgentException {
		if (validateAgent(agent)==true) {
			return dao.addAgentDao(agent);
		}
		throw new AgentException(sb.toString());
	}
	
	public boolean validateAgent(Agent agent){
		boolean flag = true;
		
		if(agent.getFirstName().length()<4){
			flag= false;
			sb.append("Firstname contains min 4 chars  \r\n");
		}
		
		if(agent.getLastName().length()<4){
			flag= false;
			sb.append("Lastname contains min 4 chars  \r\n");
		}
		if(agent.getCity().contains("Delhi")){
			//System.out.println(agent.getCity());
			flag= false;
			sb.append("City cannot be Delhi \r\n");
		}
		
		if(agent.getPremium()<5000 || agent.getPremium()>99000){
			flag= false;
			sb.append("premium must be from 5000 to 99000\r\n");
		}
		
		
		return flag;
		
	}
	
}
