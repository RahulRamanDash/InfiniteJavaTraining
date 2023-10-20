<%@page import="java.util.List"%>
<%@page import="com.java.infinite.LeaveDetails"%>
<%@page import="com.java.infinite.LeaveDetailsDAOImpl"%>
<%@page import="com.java.infinite.LeaveDetailsDAO"%>
<%@page import="com.java.infinite.Employee"%>
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
<body>
<%
			int empId = Integer.parseInt(request.getParameter("empid"));
			%>
	<table border="3" align="center">
		<th>LeaveId</th>
		<th>EmpId</th>
		<th>LeaveStartDate</th>
		<th>LeaveEndDate</th>
		<th>noOfDays</th>
		<th>leaveType</th>
		<th>leaveStatus</th>
		<th>leaveReason</th>
		<th>ManagerComments</th>
		<th>appliedOn</th>
	<%
	LeaveDetailsDAO obj = new LeaveDetailsDAOImpl();
	List<LeaveDetails> leavelist = obj.showPendingLeaveDao(empId);
	int leaveid=1;
	for(LeaveDetails leave : leavelist) {
	if(leavelist!=null){
		leaveid = leave.getLeaveId();
%>
	
	<tr>
		<td><%=leave.getLeaveId() %>  </td>
		<td><%=leave.getEmpId() %> </td>
		<td><%=leave.getLeaveStartDate() %> </td>
		<td><%=leave.getLeaveEndDate() %> </td>
		<td><%=leave.getNoOfDays() %> </td>
		<td><%=leave.getLeaveType() %> </td>
		<td><%=leave.getLeaveStatus() %> </td>
		<td><%=leave.getLeaveReason() %> </td>
		<td><%=leave.getManagerComments() %> </td>
		<td><%=leave.getAppliedOn() %> </td>
	</tr>
<%
	}else{
		out.println("No Leave Found");
	}
	}
	
	%>
	</table>
	<br><br>
	<center>
		<a href="ApproveDeny.jsp?leaveid=<%=leaveid%>" class="button">Take Action</a>
	</center>
</body>
</html>