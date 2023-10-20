<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <form action="calculation.jsp" method="get">
        <center>
            First No : 
            <input type="number" name="fnum"><br><br>
            Second No : 
            <input type="number" name="snum"><br>
            <br><br>
            <input type="submit" value="Calculate">
        </center>
    </form>
    <%
    if (request.getParameter("fnum")!=null && request.getParameter("snum")!=null){
    	
    int num1,num2,sum,sub,mul;
    num1 = Integer.parseInt(request.getParameter("fnum"));
    num2 = Integer.parseInt(request.getParameter("snum"));
    sum = num1+ num2;
    out.println("<center>"+"Sum is :"+sum+"</center>");
    sub = num1- num2;
    out.println("<center>"+"Sub is :"+sub+"</center>");
    mul = num1* num2;
    out.println("<center>"+"Mul is :"+mul+"</center>");
    }
    %>
</body>
</html>