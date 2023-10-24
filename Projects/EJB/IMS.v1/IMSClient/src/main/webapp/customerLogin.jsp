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
		<h:outputText value="Customer Login" />
	</h2>
	<h:form id="form">
		<h:outputText value="UserName " />
		<h:inputText id="uname" value="#{customer.userName}" />
		<br />

		<h:outputText value="Password " />
		<h:inputText id="pass" value="#{customer.passCode}" />
		<br />
		<h:commandButton action="#{customerImpl.validateLogin(customer)}"
			value="Login" />
		<br />
		<br />
		<h:outputText value="#{loginError}" />

	</h:form>
</body>
	</html>
</f:view>