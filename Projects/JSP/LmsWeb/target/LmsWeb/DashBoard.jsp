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
        transition: background-color 0.3s ease; /* Smooth background color transition */
    }

    a:hover {
        background-color: #258cd1; /* Darker Blue on Hover */
    }
</style>
<body>
	<center>
		 <h1>Leave Application DashBoard</h1>
	</center>
	<table border="3" align="center" id="tab1">
		<tr>
			
			<td>
			<%
				EmployeeDAO dao = new EmployeeDAOImpl();
				int empId = Integer.parseInt(request.getParameter("empId"));
        			session.setAttribute("empId", empId);
				Employee employee = dao.searchEmployeeDao(empId);
			%>
			Employee Id : <%=employee.getEmpId() %> <br/>
				Employee Name : <%=employee.getEmpName() %> <br/>
					Employee Email : <%=employee.getEmpEmail() %> <br/>
			</td>
			
			<td>
				<%
					int mgrId = Integer.parseInt(request.getParameter("mgrId"));
				if (mgrId!=0){
				Employee manager = dao.searchEmployeeDao(mgrId);					
				%>
				Manager Id : <%=manager.getEmpId() %> <br/>
				Manager Name : <%=manager.getEmpName() %> <br/>
					Manager Email : <%=manager.getEmpEmail() %> <br/>
			<%			
				}else{
					out.println("No Manager Found");
				}
			%>
			</td>
		</tr>
	</table>
	<br>
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
	List<LeaveDetails> leavelist = obj.showLeaveDao(empId);
	int empid=1;
	if(leavelist!=null){
	for(LeaveDetails leave : leavelist) {
		empid = leave.getEmpId();
%>
	
	<tr>
		<td><br><%=leave.getLeaveId() %> <br></td>
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
	}
	}else{
		out.println("No Leave Found");
	}
	%>
	</table>
	<br><br>
	<center>
	<a href="ApplyLeave.jsp?empid=<%=employee.getEmpId()%>" class="button">Apply Leave</a>
	<%
	LeaveDetailsDAO dao1 = new LeaveDetailsDAOImpl();
	List<LeaveDetails> searchleavelist = dao1.showPendingLeaveDao(empid);
%>
<br><br>
<center>
<table border="3" align="center">
		<center>
		  	<h2>Reporting Employ LeaveApplication Section</h2>
		</center>
	<tr>
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
			<th>Approve/Deny</th>
		</tr>
	<%
		if (searchleavelist.isEmpty()) {
	%>
		<tr>
			<td colspan="12"><h2>No leave found</h2></td>
		</tr>
	<%
		} else {
			for(LeaveDetails leave : searchleavelist) {
	%>
		<tr>
		<td><br><%=leave.getLeaveId() %>  <br></td>
		<td><%=leave.getEmpId() %> </td>
		<td><%=leave.getLeaveStartDate() %> </td>
		<td><%=leave.getLeaveEndDate() %> </td>
		<td><%=leave.getNoOfDays() %> </td>
		<td><%=leave.getLeaveType() %> </td>
		<td><%=leave.getLeaveStatus() %> </td>
		<td><%=leave.getLeaveReason() %> </td>
		<td><%=leave.getManagerComments() %> </td>
		<td><%=leave.getAppliedOn() %> </td>
		<td>
			<a href="ApproveDeny.jsp?leaveId=<%=leave.getLeaveId() %>" class="button">Approve/Deny</a>
		</td>
		
	</tr>
	<%	
			}
		}
	%>
	
</table>
</center>
</body>
</html>