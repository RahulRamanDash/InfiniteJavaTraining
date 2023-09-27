<%@page import="com.java.agentdashboard.Gender"%>
<%@page import="com.java.agentdashboard.Agent"%>
<%@page import="com.java.agentdashboard.AgentDAOImpl"%>
<%@page import="com.java.agentdashboard.AgentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#56a7f8">
<%
	int agentid = Integer.parseInt(request.getParameter("agentid"));
	AgentDAO dao = new AgentDAOImpl();
	Agent agent = dao.searchAgentDao(agentid);
%>
<form method="get" action="UpdateAgent.jsp">
	<center>
	Agent ID : 
		<input type="number" name="agentid" readonly="readonly" 
			value=<%=agent.getAgentID() %> /> <br/><br/>
	Agent Name : 
		<input type="text" name="name" 
			value=<%=agent.getName() %> /> <br/><br/>
	City : 
	<input type="text" name="city" 
			value=<%=agent.getCity() %> /> <br/><br/> 
	Gender : 
	<input type="text" name="gender" 
		value=<%=agent.getGENDER() %> /> <br/><br/>

	Marital Status : 
	<input type="text" name="status" 
			value=<%=agent.getMaritalStatus() %> /> <br/><br/>
	Premium : 
	<input type="number" name="premium" 
			value=<%=agent.getPremium() %> /> <br/><br/>
	<input type="submit" value="Update Agent" />
	</center>
</form>
<%
	if(request.getParameter("agentid")!=null &&
		request.getParameter("premium")!=null
		){
		Agent agentUpdated = new Agent();
		agentUpdated.setAgentID(Integer.parseInt(request.getParameter("agentid")));
		agentUpdated.setName(request.getParameter("name"));
		agentUpdated.setCity(request.getParameter("city"));
		agentUpdated.setGENDER(Gender.valueOf(request.getParameter("gender").trim()));
		agentUpdated.setMaritalStatus(Integer.parseInt(request.getParameter("status")));
		agentUpdated.setPremium(Double.parseDouble(request.getParameter("premium")));
		dao.updateAgentDao(agentUpdated);
%>

<jsp:forward page="ShowAgent.jsp"/>

<%

}

%>
</body>
</html> 