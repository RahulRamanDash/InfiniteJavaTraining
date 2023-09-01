package com.java.agent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.java.agent.Agent;

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
		int id = incrimentAgent();
		agent.setAgentId(id);
		agentList.add(agent);
		return "Agent is Added";
	}

	@Override
	public Agent searchAgentDao(int agentid) {
		Agent agentFound = null;
		for(Agent agent : agentList){
			if(agent.getAgentId()==agentid){
			agentFound =agent;
			break;
		}
	}
		return agentFound;
	}

	@Override
	public String deleteAgentDao(int agentno) {
		Agent agentFound = searchAgentDao(agentno);
		if(agentFound !=null){
			agentList.remove(agentFound);
			return "Agent Record Deleted...";
		}
		
		
		return "Agent Record Not Found";
	}

	@Override
	public String updateAgentDao(Agent agentUpdated) {
		Agent agentFound = searchAgentDao(agentUpdated.getAgentId());
		
		if(agentFound != null){
			for (Agent agent : agentList) {
				if(agent.getAgentId()==agentUpdated.getAgentId()){
					agent.setFirstName(agentUpdated.getFirstName());
					agent.setLastName(agentUpdated.getLastName());
					agent.setPayMode(agentUpdated.getPayMode());
					agent.setCity(agentUpdated.getCity());
					agent.setPremium(agentUpdated.getPremium());
					break;
				}
			}
			return "Agent Record Updated";
		}
		
		return "Agent Record Not Found";
	}

	@Override
	public String writeAgentFileDao() throws IOException {
		FileOutputStream fout = new FileOutputStream("D:/infinitejava/Day 6/AgentProject/src/com/java/agent/files/AgentData.txt");
		ObjectOutputStream objout = new ObjectOutputStream(fout);
		objout.writeObject(agentList);
		objout.close();
		fout.close();
	
	return "***Data Stored in File***";
}

	@Override
	public String ReadAgentFileDao() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream("D:/infinitejava/Day 6/AgentProject/src/com/java/agent/files/AgentData.txt");
		ObjectInputStream objin = new ObjectInputStream(fin);
		agentList = (List<Agent>) objin.readObject();
		
		objin.close();
		fin.close();
		return "Data Retracted From File";
	}
	
	

}
