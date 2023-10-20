<%@page import="com.java.jspdemo.Employ"%>
<%@page import="java.util.List"%>
<%@page import="com.java.jspdemo.EmployDAOimpl"%>
<%@page import="com.java.jspdemo.EmployDAO"%>
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
	EmployDAO dao = new EmployDAOimpl();
	List<Employ> employlist = dao.showEmployDao();
%>
<table border="3px" align="center">
	<tr>
		<th>Employ No</th>
		<th>Employ Name</th>
		<th>Gender</th>
		<th>Department</th>
		<th>Designation</th>
		<th>Basic</th>
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
	</tr>	
	<%
	}
	%>
</table>

</body>
</html>