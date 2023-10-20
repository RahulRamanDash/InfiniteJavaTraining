<%@page import="com.java.complaint.Resolve"%>
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
    <title>Complaint History</title>
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
    </style>
</head>
<body>
<%
    ComplaintDAO dao = new ComplaintDAOImpl();
	ComplaintDAOImpl impl = new ComplaintDAOImpl();
    List<Resolve> historyList = dao.complaintHistoryDao();
%>
    <header>
        <h1>Complaint History</h1>
    </header>
    <nav>
    	<a href="showComplaints.jsp">Show Complaints</a>
        <a href="addcomplaint.jsp">Raise a Complaint</a>
        <a href="showHistory.jsp">Show History</a>

    </nav>
    <div class="container">
        <table border="3px">
            <tr>
                <th>ResolveID</th>
                <th>ComplaintID</th>
                <th>Complaint Date</th>
                <th>Resolve Date</th>
                <th>ResolvedBy</th>
                <th>Comments</th>
                <th>Tat</th>
            </tr>
            <%
            for(Resolve history : historyList){
            	int tat = impl.calculateTAT2inp(history.getComplaintDate(),history.getResolveDate());
    		    String rowColor = "";
    		    
    		    if (tat > 7 && tat < 10) {
    		        rowColor = "background-color: pink;";
    		    }
    		    if (tat >= 10) {
    		        rowColor = "background-color: red;";
    		    }
                %>
            <tr style="<%= rowColor %>">
                <td><%= history.getResolveID() %></td>
                <td><%= history.getComplaintID() %></td>
                <td><%= history.getComplaintDate() %></td>
                <td><%= history.getResolveDate() %></td>
                <td><%= history.getResolvedBy() %></td>
                <td><%= history.getComments() %></td>
                <td><%=impl.calculateTAT2inp(history.getComplaintDate(),history.getResolveDate()) %></td>
            </tr>
            <%
            }
            %>
        </table>
    </div>
</body>
</html>