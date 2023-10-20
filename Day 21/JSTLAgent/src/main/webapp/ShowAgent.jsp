<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="connection"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/exam"
	user="root"
	password="root" 
/>
<sql:query var="agentQuery" dataSource="${connection}">
	select * from Agent
</sql:query>
</body>
<c:forEach var="agent" items="${agentQuery.rows}">
	Employ No :
	<c:out value="${agent.agentid}"/> <br/>
	Employ Name : 
	<c:out value="${agent.name}"/> <br/>
	Gender : 
	<c:out value="${agent.City}"/> <br/>
	Department : 
	<c:out value="${agent.gender}"/> <br/>
	Designation : 
	<c:out value="${agent.MaritalStatus}"/> <br/>
	Basic : 
	<c:out value="${agent.Premium}"/> <br/>
	
	<hr/>
</c:forEach>
</html>