<%@page import="com.java.complaint.Complaints"%>
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
	ComplaintDAO dao = new ComplaintsDaoImpl();
	ComplaintsDaoImpl impl = new ComplaintsDaoImpl();
	List<Complaints> complaintList = dao.showComplaintsDao();
%>
	<table border="3px">
		<tr>
			<th>Complaint_ID</th>
			<th>Complaint</th>
			<th>status</th>
			<th>regdate</th>
			<th>NoOfDays</th>
		</tr>
		<%
		for(Complaints complaint : complaintList){
			%>
		<tr>
			<td><%=complaint.getComplaint_ID() %></td>
			<td><%=complaint.getComplaint() %></td>
			<td><%=complaint.getStatus() %></td>
			<td><%=complaint.getRegdate() %></td>
			<td><%=impl.daysDiff(complaint.getRegdate()) %></td>
		</tr>
		<% 
		}
		%>
			
	</table>
</center>
</body>
</html>