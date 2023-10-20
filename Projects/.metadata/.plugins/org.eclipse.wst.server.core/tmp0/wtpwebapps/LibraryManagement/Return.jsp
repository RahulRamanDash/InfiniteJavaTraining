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
            width: 70%;
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
        .button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
    </style>
</head>
<body>
<jsp:include page="NavBar.jsp"/>
    <%
    		String username = (String)session.getAttribute("user");
            LibraryDAO dao = new LibraryDaoImpl();
            List<Tranbook> historylist;
            
                historylist = dao.showHistoryDao("iconic");
    %>
    <center>
    <form action="Return.jsp" method="get">
                <table border="3px">
                    <tr>
                        <th>UserName</th>
                        <th>BookId</th>
                        <th>Fromdate</th>
                        <th>Return</th>
                    </tr>
                    <%
                    for(Tranbook history :historylist) {
                    %>
		    			<tr>
		        			<td><%=history.getUsername() %></td>
		        			<td><%= history.getBookId() %></td>
		        			<td><%= history.getFromdate() %></td>
		        			<td><input type="checkbox" name="box" value=<%=history.getBookId()%>/></td>
		    			</tr>
				<%
				}
				%>
                </table>
                <br><br>
				<input type="submit" class="button" value="Return"/>
    </form>                
    </center>
</body>
</html>