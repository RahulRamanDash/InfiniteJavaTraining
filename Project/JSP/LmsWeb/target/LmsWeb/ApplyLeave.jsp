<%@page import="com.java.infinite.LeaveDetailsDAO"%>
<%@page import="com.java.infinite.LeaveDetailsDAOImpl"%>
<%@page import="com.java.infinite.LeaveType"%>
<%@page import="java.util.Date"%>
<%@page import="com.java.infinite.LeaveDetails"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Application Form</title>
<style>
    /* Remove border from table and form elements */
    table, th, td {
        border: none;
    }

    body {
        background-color: #f2f2f2; /* Light Gray */
        font-family: Arial, sans-serif;
    }

    /* Stylish form container */
    .form-container {
        background-color: #fff; /* White */
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
        margin: 20px auto;
        width: 60%;
        max-width: 600px;
    }

    h1 {
        text-align: center;
        color: #333; /* Dark Gray */
    }

    /* Stylish form elements */
    input[type="text"], select {
        width: 100%;
        padding: 12px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="text"]:focus, select:focus {
        border-color: #007bff; /* Blue on focus */
    }

    label {
        font-weight: bold;
    }

    /* Stylish submit button */
    input[type="submit"] {
        background-color: #007bff; /* Blue */
        color: #fff;
        border: none;
        border-radius: 4px;
        padding: 12px 20px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3; /* Darker Blue on hover */
    }
</style>
</head>
<body>
<%
int empId = (int)session.getAttribute("empId");
%>
    <center>
        <h1>Leave Application Form</h1>
        <form action="ApplyLeaveMain.jsp" method="post">
            <table>
                <tr>
                    <td><label for="emp_id">Employee ID:</label></td>
                    <td><input type="text" name="emp_id" value="<%=empId%>" readonly></td>
                </tr>
                <tr>
                    <td><label for="leave_start_date">Leave Start Date (yyyy-MM-dd):</label></td>
                    <td><input type="text" id="leave_start_date" name="leave_start_date" required></td>
                </tr>
                <tr>
                    <td><label for="leave_end_date">Leave End Date (yyyy-MM-dd):</label></td>
                    <td><input type="text" id="leave_end_date" name="leave_end_date" required></td>
                </tr>
                <tr>
                    <td><label for="leave_type">Leave Type:</label></td>
                    <td>
                        <select id="leave_type" name="leave_type" required>
                            <option value="EL">EL (Earned Leave)</option>
                            <option value="PL">PL (Paid Leave)</option>
                            <option value="ML">ML (Maternity Leave)</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="leave_reason">Leave Reason:</label></td>
                    <td><input type="text" id="leave_reason" name="leave_reason" required></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Submit">
        </form>
    </center>
<%
    if (request.getParameter("emp_id")!=null && request.getParameter("leave_start_date")!=null){
    
    String leaveStartDate = request.getParameter("leave_start_date");
    String leaveEndDate = request.getParameter("leave_end_date");
    String leaveType = request.getParameter("leave_type");
    String leaveReason = request.getParameter("leave_reason");
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails leavedetails = new LeaveDetails();
    
    Date startDate = sdf.parse(leaveStartDate);
    java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
    
    java.util.Date endDate = sdf.parse(leaveEndDate);
    java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
    
    leavedetails.setEmpId(empId);
    leavedetails.setLeaveStartDate(sqlStartDate);
    leavedetails.setLeaveEndDate(sqlEndDate);
    leavedetails.setLeaveType(LeaveType.valueOf(leaveType));
    leavedetails.setLeaveReason(leaveReason);
    
    LeaveDetailsDAO dao = new LeaveDetailsDAOImpl();
    out.println(dao.applyLeave(leavedetails));
    
    %>
    <jsp:include page="EmployShow.jsp"/>
    <%
    }
%>
</body>
</html>
