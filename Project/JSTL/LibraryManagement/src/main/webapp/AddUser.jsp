<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="AddUser.jsp">
		User Name : 
		<input type="text" name="userName" /> <br/><br/>
		Password : 
		<input type="password" name="passCode" /> <br/><br/>
		Re-Type Password : 
		<input type="password" name="retypePassCode" /> <br/><br/> 
		<input type="submit" value="Create Account" />
	</form>
	<c:if test="${param.userName!=null && param.passCode!=null}">
		<sql:setDataSource var="connection"
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/libraryinfinite"
		user="root"
		password="root" />
	<jsp:useBean id="enc" class="com.java.lib.EncryptPassword"/>
	<c:set var="pwd" value="${enc.getCode(param.passCode)}"/>
		<sql:update var="addUser" dataSource="${connection}">
		Insert into LibUsers(UserName,Password) values(?,?)
		<sql:param value="${param.userName}" />
		<sql:param value="${pwd}" />
		</sql:update>
	<c:out value="User Created..." />
		
	</c:if>
</body>
</html>