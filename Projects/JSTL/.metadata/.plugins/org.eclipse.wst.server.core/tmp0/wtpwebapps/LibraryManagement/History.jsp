<%@page import="com.java.lib.Transreturn"%>
<%@page import="java.util.List"%>
<%@page import="com.java.lib.Tranbook"%>
<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@page import="com.java.lib.LibraryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library History</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
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
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<jsp:include page="NavBar.jsp"/>
    <%
    		String username = (String)session.getAttribute("user");
            LibraryDAO dao = new LibraryDaoImpl();
            List<Transreturn> historylist;
            
                historylist = dao.showHistoryDao(username);
    %>
                <table border="3px">
                    <tr>
                        <th>UserName</th>
                        <th>BookId</th>
                        <th>From Date</th>
                        <th>To Date</th>
                    </tr>
                    <%
                    for(Transreturn history :historylist) {
                    %>
		    			<tr>
		        			<td><%=history.getUsername() %></td>
		        			<td><%= history.getBookId() %></td>
		        			<td><%= history.getFromdate() %></td>
		        			<td><%= history.getTodate() %></td>
		    			</tr>
				<%
				}
				%>
                </table>
</body>
</html>