<%@page import="com.java.lib.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.java.lib.LibraryDaoImpl"%>
<%@page import="com.java.lib.LibraryDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
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
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
          table {
        border: 1px solid #ccc;
        width: 90%;
    }

    td, th {
        text-align: center; /* Horizontal centering */
        vertical-align: middle; /* Vertical centering */
        height: 20px; /* Set a fixed height for table cells if needed */
    }
    </style>
</head>
<body>
<jsp:include page="Menu.jsp"/>
	<c:if test="${param.searchtype!=null && param.searchvalue!=null}">
	<jsp:useBean id="show" class="com.java.lib.Books"/>
	<jsp:setProperty property="*" name="show"/>
	<jsp:useBean id="dao" class="com.java.lib.LibraryDaoImpl"/>
	<c:set var="booksList" value="${dao.searchBooks(searchtype,searchvalue)}"/>
	</c:if>
		<form action="Issue.jsp" method="">
		<table border="3" align="center">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>
			<th>Edition</th>
			<th>Department</th>
			<th>Total Books</th>
			<th>Select</th>
		</tr>
		<c:forEach var="book" items="${booksList}">
		    <tr>
		        <td><c:out value="${book.id}" /></td>
		        <td><c:out value="${book.name}" /></td>
		        <td><c:out value="${book.author}" /></td>
		        <td><c:out value="${book.edition}" /></td>
		        <td><c:out value="${book.dept}" /></td>
		        <td><c:out value="${book.noOfBooks}" /></td>
		        <c:if test="${book.noOfBooks>0}">
		        <td><input type="checkbox" name="box" value="${book.id}"/></td>
		        </c:if>
		    </tr>
		</c:forEach>
	</table>
	<br>
	<center>
	<input type="submit" value="Issue Book(s)" />
	</center>
	</form>
</body>
</html>