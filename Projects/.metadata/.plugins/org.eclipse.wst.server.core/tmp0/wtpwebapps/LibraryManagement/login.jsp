<%@page import="com.java.lib.LibUsers"%>
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
/* Center the form on the page */
 body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
center {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 70vh; /* Vertical centering */
}

/* Style the form container */
form {
    background-color: lightblue;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center; /* Center form elements horizontally */
    width: 300px; /* Adjust the width as needed */
}

/* Style the form heading */
h2 {
    color: #007BFF;
    font-size: 24px;
}

/* Style input fields */
input[type="text"],
input[type="password"] {
    width: 90%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}

/* Style the submit button */
input[type="submit"] {
    background-color: #007BFF;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
}

/* Hover effect for the submit button */
input[type="submit"]:hover {
    background-color: #0056b3;
}

</style>
</head>
<body>
		<center>
		<form method="post" action="login.jsp">
			<h2>Please Login :</h2>
			Username : <input type="text" name="userName"> <br/><br/>
			Password : <input type="password" name="passWord"> <br/><br/>
			<input type="submit" value="Login">
		</form>
	</center>
	<c:if test="${param.userName!=null && param.passWord!=null}">
	<jsp:useBean id="login" class="com.java.lib.LibUsers"/>
	<jsp:setProperty property="*" name="login"/>
	<jsp:useBean id="dao" class="com.java.lib.LibraryDaoImpl"/>
	<c:set var="count" value="${dao.authenticate(login)}"/>
	<c:if test="${count==1}">
		<%
			session.setAttribute("user", request.getParameter("userName"));
		%>
		<jsp:forward page="Menu.jsp"/>
	</c:if>
	<c:if test="${count==0}">
		<c:out value="Invalid Credentials..."/>
	</c:if>
	
</c:if>



</body>
</html>