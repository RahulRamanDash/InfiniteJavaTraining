<%@page import="com.java.infinite.LeaveDetails"%>
<%@page import="com.java.infinite.LeaveDetailsDAOImpl"%>
<%@page import="com.java.infinite.LeaveDetailsDAO"%>
<%@page import="com.java.infinite.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.java.infinite.EmployeeDAOImpl"%>
<%@page import="com.java.infinite.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 90%;
        margin: 20px auto;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 12px;
        text-align: center;
    }

    th {
        background-color: #4CAF50; /* Green */
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #E0E0E0; /* Light Gray */
    }

    a {
        text-decoration: none;
        color: #fff;
        background-color: #3498db; /* Blue */
        font-weight: bold;
        padding: 8px 16px;
        border-radius: 4px;
        display: inline-block;
        transition: background-color 0.3s;
    }

    a:hover {
        background-color: #258cd1; /* Darker Blue on Hover */
    }
</style>




<body>
<%
	EmployeeDAO dao = new EmployeeDAOImpl();
	List<Employee> employeeList = dao.showEmployeeDao();
%>
<center>
<table border="3" align="center">
	<tr>
		<th>Employ Id</th>
		<th>Employ Name</th>
		<th>Employ Email</th>
		<th>Employ MobileNo</th>
		<th>Employ DateOfJoin</th>
		<th>Employ ManagerId</th>
		<th>Employ LeaveAvail</th>
		<th>Show</th>
	</tr>
	<%
		int empid;
		for(Employee employee : employeeList) {
			 empid = employee.getEmpId();
	%>
		<tr>
			<td><%=employee.getEmpId() %> </td>
			<td><%=employee.getEmpName() %>  </td>
			<td><%=employee.getEmpEmail() %> </td>
			<td><%=employee.getMobileNo() %> </td>
			<td><%=employee.getDateOfJoin() %> </td>
			<td><%=employee.getManagerId() %> </td>
			<td><%=employee.getLeaveAvail() %> </td>
			<td> 
				<a href=DashBoard.jsp?empId=<%=employee.getEmpId() %>&mgrId=<%=employee.getManagerId() %> >Show</a>
			</td>
		</tr>
	<%
		}
	%>
	
</table>
</center>
</body>
</html>