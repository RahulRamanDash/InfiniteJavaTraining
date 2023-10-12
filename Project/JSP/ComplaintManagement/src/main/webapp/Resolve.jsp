<%@page import="com.java.complaint.Complaint"%>
<%@page import="com.java.complaint.Resolve"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resolve Complaint</title>
<style>
body {
	text-align: center;
}

.form-container {
	margin: 0 auto; /* Center horizontally */
	text-align: center; /* Reset text alignment for form contents */
	padding: 20px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<%
	if(request.getParameter("ComplaintID")!=null){
		String complaintID = request.getParameter("ComplaintID");
		ComplaintDAO dao = new ComplaintDAOImpl();
		Complaint comp = dao.searchComplaintDao(complaintID);
	%>
	<div class="form-container">
		<h2>Complaint Resolution Form</h2>
		<form action="ResolvePrint.jsp" method="POST">
			<label for="ComplaintID">Complaint ID:</label> <input type="text"
				value="<%=complaintID%>" name="ComplaintID" readonly="readonly"><br>
			<br> <label for="ResolvedBy">Resolved By:</label> <input
				type="text" id="ResolvedBy" name="ResolvedBy"><br>
			<br> <label for="Comments">Comments:</label> <input type="text"
				id="Comments" name="Comments" /><br>
			<br> <input type="submit" value="Submit">
		</form>
	</div>

	<%
	if(request.getParameter("ResolvedBy")!=null && request.getParameter("Comments")!=null){
		
		Resolve resolve = new Resolve();
		String resolvedBy = request.getParameter("ResolvedBy");
		String comments = request.getParameter("Comments");
		resolve.setComplaintID(complaintID);
		resolve.setResolvedBy(resolvedBy);
		resolve.setComments(comments);	
		out.println(dao.resolveComplaintDao(resolve));
		%>
		<jsp:forward page="showComplaints.jsp"/>
	<%
	}
}else{
	out.println("Come With a ComplaintID");
}
	%>
</body>
</html>