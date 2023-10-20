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
<style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
<body>
 <h1>Search for Complaint</h1>
    
    <%-- Check if the form is submitted --%>
    <%
        String complaintid = request.getParameter("complaintid");
        if (complaintid != null) {
            // Import your Complaint and ComplaintDAO classes here

            ComplaintDAO dao = new ComplaintDAOImpl(); // Initialize this appropriately

            // Call the searchComplaintDAO method to search for the complaint
            Complaint complaint = dao.searchComplaintDAO(complaintid);

            if (complaint != null) {
    %>
                <table>
            <tr>
                <th>Complaint ID</th>
                <th>Complaint Type</th>
                <th>Description</th>
                <th>Severity</th>
                <th>Status</th>
                <th>Complaint Date</th>
            </tr>
            <tr>
                <td><%= complaint.getComplaintid() %></td>
                <td><%= complaint.getComplaintType() %></td>
                <td><%= complaint.getCDescription() %></td>
                <td><%= complaint.getSeverity() %></td>
                <td><%= complaint.getStatus() %></td>
                <td><%= complaint.getComplaintDate() %></td>
            </tr>
        </table>
                <br><br>
    <%
            } else {
    %>
                <p>Complaint not found.</p>
    <%
            }
        }
    %>
    
    <form method="get">
        <label for="complaintid">Complaint ID:</label>
        <input type="text" id="complaintid" name="complaintid" required>
        <button type="submit">Search</button>
    </form>

</body>
</html>