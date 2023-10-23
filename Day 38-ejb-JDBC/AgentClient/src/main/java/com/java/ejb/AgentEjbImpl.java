package com.java.ejb;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class AgentEjbImpl {

	public List<Agent> showAgentEjb() throws NamingException, ClassNotFoundException, SQLException {
	 AgentBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
	 return remote.showAgent();
	}
	public String searchAgentEjb(int agentid) throws NamingException, ClassNotFoundException, SQLException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		AgentBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
		Agent agent = remote.searchAgent(agentid);
		sessionMap.put("editAgent", agent);
		System.out.println(agent);
		return "UpdateAgent.jsp?faces-redirect=true";
	}
	public String updateAgentEjb(Agent editAgent) throws NamingException, ClassNotFoundException, SQLException {
		 AgentBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
		 remote.updateAgent(editAgent);
		 return "ShowAgent.jsp?faces-redirect=true";
		}
	public String deleteAgentEjb(int agentid) throws NamingException, ClassNotFoundException, SQLException {
		 AgentBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
		 remote.deleteAgent(agentid);
		 return "ShowAgent.jsp?faces-redirect=true";
		}
	public String addAgentEjb(Agent agent) throws NamingException, ClassNotFoundException, SQLException {
		 AgentBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
		 remote.addAgent(agent);
		 return "ShowAgent.jsp?faces-redirect=true";
		}
}