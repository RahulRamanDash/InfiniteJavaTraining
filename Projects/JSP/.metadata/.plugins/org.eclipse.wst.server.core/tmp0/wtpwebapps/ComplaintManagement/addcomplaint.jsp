<%@page import="com.java.complaint.Complaint"%>
<%@page import="com.java.complaint.ComplaintDAOImpl"%>
<%@page import="com.java.complaint.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Raise Complaint</title>
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
            margin: 0 10px;
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

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <h1>Raise Complaint</h1>
    </header>
    <nav>
    	<a href="showComplaints.jsp">Show Complaints</a>
        <a href="addcomplaint.jsp">Raise a Complaint</a>
        <a href="showHistory.jsp">Show History</a>
    </nav>
    <div class="container">
        <form action="addcomplaint.jsp" method="post">
            <label for="ComplaintType">Complaint Type:</label>
            <input type="text" name="ComplaintType"><br>

            <label for="CDescription">Description:</label>
            <input type="text" name="CDescription"><br>

            <label for="severity">Severity:</label>
            <select name="severity">
                <option value="LOW">LOW</option>
                <option value="MEDIUM">MEDIUM</option>
                <option value="HIGH">HIGH</option>
            </select><br>

            <input type="submit" value="Submit">
        </form>
        <%
        if(request.getParameter("ComplaintType")!=null && request.getParameter("CDescription")!=null){
            Complaint complaint = new Complaint();
            
            complaint.setComplaintType(request.getParameter("ComplaintType"));
            complaint.setCDescription(request.getParameter("CDescription"));
            complaint.setSeverity(request.getParameter("severity"));
            
            ComplaintDAO complaintDAO = new ComplaintDAOImpl();
            complaintDAO.addComplaintDao(complaint);
        %>
        <jsp:forward page = "showComplaints.jsp"/>
        <%
        }
        %>
    </div>
</body>
</html>
