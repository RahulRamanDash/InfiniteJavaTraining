<%@page import="com.java.complaint.Resolve"%>
<%@page import="com.java.complaint.Complaint"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resolve</title>
</head>
<body>
	<%
	if(request.getParameter("ComplaintID")!=null){
		String complaintID = request.getParameter("ComplaintID");
		ComplaintDAO dao = new ComplaintDAOImpl();
		Complaint comp = dao.searchComplaintDao(complaintID);
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