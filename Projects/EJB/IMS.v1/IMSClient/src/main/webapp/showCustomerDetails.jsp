<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<style>
body {
	text-align: center; /* Center text within the body */
	margin: 0 auto; /* Center the body horizontally */
}
</style>
</head>
<body>
	<h2>
		<h:outputText value="Customer Details" />
	</h2>
	<br/>
        <jsp:include page="CustomerMenu.jsp"/>
	<h:form id="form">
	
		<h:outputText value="Customer Id " />
		<h:inputText id="custid" value="#{customerFound.custId}" />
		<br />
		<h:outputText value="FirstName " />
		<h:inputText id="fname" value="#{customerFound.firstName}" />
		<br />
		<h:outputText value="LastName " />
		<h:inputText id="lname" value="#{customerFound.lastName}" />
		<br />
		<h:outputText value="Gender " />
		<h:inputText id="gender" value="#{customerFound.gender}" />
		<br />
		<h:outputText value="DateOfBirth " />
		<h:inputText id="dob" value="#{customerFound.dateOfBirth}" />
		<br />
		<h:outputText value="UserName " />
		<h:inputText id="uname" value="#{customerFound.userName}" />
		<br />
		<h:outputText value="Email " />
		<h:inputText id="email" value="#{customerFound.email}" />
		<br />
		<h:outputText value="Status " />
		<h:inputText id="status" value="#{customerFound.status}" />
		<br/><br/>
		
	</h:form>
</body>
	</html>
</f:view>