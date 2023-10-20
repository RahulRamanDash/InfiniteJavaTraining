<%@page import="com.java.jsp.Complaint"%>
<%@page import="com.java.jsp.ComplaintDAOImpl"%>
<%@page import="com.java.jsp.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Raise Complaint</h1>

    <form action="addcomplaint.jsp" method="post">
        <label for="complaintid">Complaint ID:</label>
        <input type="text" id="complaintid" name="complaintid"><br>

        <label for="ComplaintType">Complaint Type:</label>
        <input type="text" id="ComplaintType" name="ComplaintType"><br>

        <label for="CDescription">Description:</label>
        <textarea id="CDescription" name="CDescription"></textarea><br>

        <label for="severity">Severity:</label>
        <input type="text" id="severity" name="severity"><br>
        
        <label for="status">Status:</label>
        <input type="text" id="status" name="status"><br>

        <input type="submit" value="Submit">
    </form>
		
		
		<%
    
		if(request.getParameter("complaintid")!=null && request.getParameter("ComplaintType")!=null){
		    // Create a Complaint object with the form data
		    Complaint comp = new Complaint();
		    comp.setComplaintid(request.getParameter("complaintid"));
		    comp.setComplaintType(request.getParameter("ComplaintType"));
		    comp.setCDescription(request.getParameter("CDescription"));
		    comp.setSeverity(request.getParameter("severity"));
		    comp.setStatus(request.getParameter("status"));


		    // Create an instance of ComplaintDAOImpl to insert the data
		    ComplaintDAO complaintDAO = new ComplaintDAOImpl();
    
    		complaintDAO.addComplaintDAO(comp);
		
%>

    <jsp:forward page = "ComplaintShow.jsp"/>
		<%
		
		}
		%>
       

</body>
</html>