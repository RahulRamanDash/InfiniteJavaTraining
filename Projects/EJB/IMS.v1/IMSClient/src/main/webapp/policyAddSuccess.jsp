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
	<br/>
	<h3>
		<h:outputText value="Policy Claimed Sucessfully...." />
	</h3>
	<br/><br/>
	
	<h:form id="form">
	
		<h:outputText value="Next Due Date is #{dueDateStr}" />
		<br/>
		<h:outputText value="Initial Amount is Rs #{initialAmount}" />
		<br/>
		<h:commandButton action="userDashboard" value="Go To Home" />
	</h:form>
</body>
	</html>
</f:view>