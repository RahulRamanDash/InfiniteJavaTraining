<%@page import="com.java.complaint.Complaint"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="com.java.complaint.ComplaintsDaoImpl"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<%
	ComplaintDAO dao = new ComplaintDAOImpl();
	ComplaintDAOImpl impl = new ComplaintDAOImpl();
	List<Complaint> complaintList = dao.showComplaintDao();
%>
	<table border="3px">
		<tr>
			<th>Complaint ID</th>
            <th>Complaint Type</th>
            <th>Description</th>
            <th>Complaint Date</th>
            <th>Severity</th>
            <th>Status</th>
			<th>Resolve</th>
		</tr>
		<%
		for(Complaint complaint : complaintList){
			%>
		<tr>
			<td><%= complaint.getComplaintID() %></td>
            <td><%= complaint.getComplaintType() %></td>
            <td><%= complaint.getCDescription() %></td>
			<td><%= complaint.getComplaintDate() %></td>
			<td><%= complaint.getSeverity() %></td>
            <td><%= complaint.getStatus() %></td>
            <td><a href="Resolve.jsp?ComplaintID=<%= complaint.getComplaintID() %>">Resolve</a></td>
		</tr>
		<% 
		}
		%>
			
	</table>
</center>
</body>
</html>