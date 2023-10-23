<%@page import="com.java.agentdashboard.Agent"%>
<%@page import="com.java.agentdashboard.AgentDAOImpl"%>
<%@page import="com.java.agentdashboard.AgentDAO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent </title>
</head>
<body bgcolor="#56a7f8">
<%
	AgentDAO dao = new AgentDAOImpl();
	List<Agent> agentlist = dao.showAgentDao();
%>
<table border="2px" align="center" style="background-color:#2ee521; font-size: 25px; color: darkblack;">
	<tr>
		<th>Agent ID</th>
		<th>Agent Name</th>
		<th>City</th>
		<th>Gender</th>
		<th>MaritalStatus</th>
		<th>Premium</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<%
	for(Agent agent : agentlist){
	
		%>
	<tr>
		<td><%=agent.getAgentID() %></td>
		<td><%=agent.getName() %> </td>
		<td><%=agent.getCity() %> </td>
		<td><%=agent.getGENDER() %> </td>
		<td><%=agent.getMaritalStatus() %> </td>
		<td><%=agent.getPremium() %> </td>
		<td>
			<a href=UpdateAgent.jsp?agentid=<%=agent.getAgentID() %>>Update</a>
		</td>
		<td>
			<a href=DeleteAgent.jsp?agentid=<%=agent.getAgentID() %>>Delete</a>
		</td>
	</tr>	
	<%
	}
	%>
</table>
<center>
<br><br>
	<a href="AddAgent.jsp">Add Agent</a>
	
</center>
</body>
</html>