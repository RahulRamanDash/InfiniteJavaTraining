<%@page import="com.java.infinite.Employee"%>
<%@page import="com.java.infinite.EmployeeDAOImpl"%>
<%@page import="com.java.infinite.EmployeeDAO"%>
<%@page import="com.java.infinite.LeaveDetails"%>
<%@page import="com.java.infinite.LeaveDetailsDAOImpl"%>
<%@page import="com.java.infinite.LeaveDetailsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        background-color: #f0f0f0; /* Light Gray Background */
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    .container {
        background-color: #ffffff; /* White Container */
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
        margin: 20px auto;
        width: 80%;
        max-width: 600px;
    }

    h1 {
        text-align: center;
        color: #333; /* Dark Gray Text */
    }

	table.form-table td {
        padding: 4px; /* Decreased padding */
        margin: 2px 0; /* Decreased margin */
    }
    
    table.form-table {
        width: 100%;
        margin-bottom: 20px;
    }

    table.form-table tr {
        vertical-align: top;
    }

    table.form-table td {
        padding: 4px;
    }

    label {
        font-weight: bold;
    }

    input[type="text"], select {
        width: 90%;
        padding: 12px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="text"]:focus, select:focus {
        border-color: #007bff; /* Blue on Focus */
    }

    select {
        width: %;
    }

    .button-container {
        text-align: center;
        margin-top: 20px;
    }

    input[type="submit"] {
        background-color: #007bff; /* Blue Button */
        color: #fff;
        border: none;
        border-radius: 4px;
        padding: 12px 20px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3; /* Darker Blue on Hover */
    }
</style>

</head>
<body>
<%
    if (request.getParameter("leaveId")!=null) {
         int leaveId = Integer.parseInt(request.getParameter("leaveId"));
         session.setAttribute("leaveId", request.getParameter("leaveId"));
    }
//  out.println(leaveId);
    String id = (String)session.getAttribute("leaveId");
    int leId = Integer.parseInt(id);
    LeaveDetailsDAO dao = new LeaveDetailsDAOImpl();
    LeaveDetails leave = dao.searchLeaveDao(leId);
    int empId = leave.getEmpId();
    EmployeeDAO edao = new EmployeeDAOImpl();
    Employee employee = edao.searchEmployeeDao(empId);
    
%>
    <center>
   <form action="ApproveDeny.jsp" method="post" class="container">
    <h1>Leave Approval Form</h1>
    <table class="form-table">
        <tr>
            <td><label for="leave_id">Leave ID:</label></td>
            <td><%=leave.getLeaveId() %></td>
        </tr>
        <tr>
            <td><label for="employee_id">Employee ID:</label></td>
            <td><%=empId %></td>
        </tr>
        <tr>
            <td><label for="employee_name">Employee Name:</label></td>
            <td><%=employee.getEmpName() %></td>
        </tr>
        <tr>
            <td><label for="leave_balance">Leave Balance:</label></td>
            <td><%=employee.getLeaveAvail() %></td>
        </tr>
        <tr>
            <td><label for="start_date">Start Date:</label></td>
            <td><%=leave.getLeaveStartDate() %></td>
        </tr>
        <tr>
            <td><label for="end_date">End Date:</label></td>
            <td><%=leave.getLeaveEndDate() %></td>
        </tr>
        <tr>
            <td><label for="no_of_days">No. of Days:</label></td>
            <td><%=leave.getNoOfDays() %></td>
        </tr>
        <tr>
            <td><label for="leave_type">Leave Type:</label></td>
            <td><%=leave.getLeaveType() %></td>
        </tr>
        <tr>
            <td><label for="leave_reason">Reason:</label></td>
            <td><%=leave.getLeaveReason() %></td>
        </tr>
        <tr>
            <td><label for="leave_status">Leave Status:</label></td>
            <td>
                <select name="status">
                    <option value="YES">YES</option>
                    <option value="NO">NO</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="manager_comment">Manager Comment:</label></td>
            <td><input type="text" name="mgcmt"></td>
        </tr>
    </table>
    <div class="button-container">
        <input type="submit" value="Submit">
    </div>
</form>
    </center>
    <%
    if(request.getParameter("status")!=null && request.getParameter("mgcmt")!=null){
    String status = request.getParameter("status");
    String mgcmt = request.getParameter("mgcmt");
    
    out.println(dao.ApproveDeny(leave.getLeaveId(), employee.getManagerId(), status, mgcmt));
    %>
    <jsp:forward page="EmployShow.jsp"/>
    <%
    }
    %>
</body>
</html>
