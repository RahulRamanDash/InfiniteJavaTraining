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
<body>
<%
	int agentid = Integer.parseInt(request.getParameter("agentid"));
	AgentDAO dao = new AgentDAOImpl();
	out.println(dao.deleteAgentDao(agentid));
%>
<jsp:forward page="ShowAgent.jsp"/>
</body>
</html>