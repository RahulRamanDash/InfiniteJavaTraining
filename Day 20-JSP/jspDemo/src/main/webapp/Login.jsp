<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="Login.jsp" method="post">
        <center>
            User Name :
            <input type="text" name="username"><br><br>
            Password :
            <input type="password" name="password" ><br><br>
            <input type="submit" value="Login">
        </center>
    </form>
    <%
    if(request.getParameter("username")!=null && request.getParameter("password")!=null){
    	String userName = request.getParameter("username");
    	String PassWord = request.getParameter("password");
    	if (userName.equals("rahul") && PassWord.equals("raman")){
    		out.println("<center>"+"Login Sucessful..."+ "</center>"); 
    		
    		%>
    		<jsp:forward page="Menu.jsp"/>
    		<%
    	}else{
    		out.println("<center>"+"Invalid Username or Password...."+"</center>");
    	}
    	
    }
    %>
</body>
</html>