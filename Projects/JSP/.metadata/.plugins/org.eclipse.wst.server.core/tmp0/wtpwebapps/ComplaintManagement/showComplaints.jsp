<%@page import="com.java.complaint.Complaint"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Complaints</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007BFF;
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        nav {
            background-color: #007BFF;
            color: #fff;
            text-align: center;
            padding: 10px 0;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            margin: 0 10px; /* Add spacing between links */
            transition: background-color 0.3s ease;
        }

        nav a:hover {
            background-color: #0056b3;
        }

        .container {
            max-width: 100%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        /* Style links as buttons */
        a.button {
            text-decoration: none;
            padding: 8px 15px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        /* Hover effect for buttons */
        a.button:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
<%
	ComplaintDAO dao = new ComplaintDAOImpl();
	ComplaintDAOImpl impl = new ComplaintDAOImpl();
	List<Complaint> complaintList = dao.showComplaintDao();
%>
    <header>
        <h1>Manage Complaints</h1>
    </header>
  	<nav>
  		<a href="showComplaints.jsp">Show Complaints</a>
        <a href="addcomplaint.jsp">Raise a Complaint</a>
        <a href="showHistory.jsp">Show History</a>
  	</nav>
<div class="container">
	<table border="3px">
		<tr>
			<th>Complaint ID</th>
            <th>Complaint Type</th>
            <th>Description</th>
            <th>Complaint Date</th>
            <th>Severity</th>
            <th>Status</th>
            <th>Tat</th>
			<th>Resolve</th>
		</tr>
		<%
		for(Complaint complaint : complaintList){
			int tat = impl.calculateTAT(complaint.getComplaintDate());
		    String rowColor = "";
		    
		    if (tat > 7 && tat < 10) {
		        rowColor = "background-color: pink;";
		    }
		    if (tat > 10) {
		        rowColor = "background-color: red;";
		    }
		
	%>
		<tr style="<%= rowColor %>">
			<td><%= complaint.getComplaintID() %></td>
            <td><%= complaint.getComplaintType() %></td>
            <td><%= complaint.getCDescription() %></td>
			<td><%= complaint.getComplaintDate() %></td>
			<td><%= complaint.getSeverity() %></td>
            <td><%= complaint.getStatus() %></td>
            <td><%=impl.calculateTAT(complaint.getComplaintDate()) %></td>
            <td><a class="button" href="Resolve.jsp?ComplaintID=<%= complaint.getComplaintID() %>">Resolve</a></td>
		</tr>
		<% 
		}
		%>
	</table>
    <br><br>
</div>
</body>
</html>