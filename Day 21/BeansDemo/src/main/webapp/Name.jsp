<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanName" class="com.java.beeans.NameBean"></jsp:useBean>
<jsp:setProperty property="*" name="beanName" />

First Name :
<jsp:getProperty property="firstName" name="beanName" />
<br><br>
Last Name :
<jsp:getProperty property="lastName" name="beanName" />

</body>
</html>