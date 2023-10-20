<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="getName.jsp" method="get">
        <center>
            Name : 
            <input type="text" name="name"><br><br>
            <input type="submit" value="Show">
        </center>
    </form>
    <%
    if (request.getParameter("name")!=null){
    	String name = request.getParameter("name");
    	out.println("Student name is " +name);
    }
    %>
</body>
</html>