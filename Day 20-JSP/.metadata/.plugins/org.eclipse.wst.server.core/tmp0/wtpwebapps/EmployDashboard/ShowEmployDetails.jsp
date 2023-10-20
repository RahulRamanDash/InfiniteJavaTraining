<%@page import="com.java.employdashboard.Employ"%>
<%@page import="java.util.List"%>
<%@page import="com.java.employdashboard.EmployDAOimpl"%>
<%@page import="com.java.employdashboard.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employ </title>
</head>
<body bgcolor="#56a7f8">
<%
	EmployDAO dao = new EmployDAOimpl();
	List<Employ> employlist = dao.showEmployDao();
%>
<table border="2px" align="center" style="background-color:#2ee521; font-size: 25px; color: darkblack;">
	<tr>
		<th>Employ No</th>
		<th>Employ Name</th>
		<th>Gender</th>
		<th>Department</th>
		<th>Designation</th>
		<th>Basic</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<%
	for(Employ employ : employlist){
	
		%>
	<tr>
		<td><%=employ.getEmpno() %></td>
		<td><%=employ.getName() %> </td>
		<td><%=employ.getGender() %> </td>
		<td><%=employ.getDept() %> </td>
		<td><%=employ.getDesig() %> </td>
		<td><%=employ.getBasic() %> </td>
		<td>
			<a href=UpdateEmploy.jsp?empno=<%=employ.getEmpno() %>>Update</a>
		</td>
		<td>
			<a href=DeleteEmploy.jsp?empno=<%=employ.getEmpno() %>>Delete</a>
		</td>
	</tr>	
	<%
	}
	%>
</table>
<center>
<br><br>
	<a href="AddEmploy.jsp">Add Employ</a>
	
</center>
</body>
</html>