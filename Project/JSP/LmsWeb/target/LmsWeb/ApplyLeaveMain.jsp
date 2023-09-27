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

</head>
<body>
<%
int empId = (int)session.getAttribute("empId");
%>
   
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
