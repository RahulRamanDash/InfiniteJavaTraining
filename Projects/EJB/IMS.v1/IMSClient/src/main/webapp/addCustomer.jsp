<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>
body {
	text-align: center; /* Center text within the body */
	margin: 0 auto; /* Center the body horizontally */
}
</style>
</head>
<body>
	<h2>
		<h:outputText value="Add Customer" />
	</h2>
	<h:form id="form">

		<h:outputText value="FirstName " />
		<h:inputText id="fname" value="#{customer.firstName}" />
		<br />

		<h:outputText value="LastName " />
		<h:inputText id="lname" value="#{customer.lastName}" />
		<br />

		<h:outputText value="Gender " />
		<h:inputText id="gender" value="#{customer.gender}" />
		<br />

		<h:outputText value="Date Of Birth " />
		<h:inputText id="dob-id" value="#{customer.dateOfBirth}"
			converterMessage="Please provide date of birth in yyyy-mm-dd format">
			<f:convertDateTime pattern="yyyy-mm-dd" />
		</h:inputText>
		<br />

		<h:outputText value="UserName " />
		<h:inputText id="uname" value="#{customer.userName}" />
		<br />

		<h:outputText value="Email " />
		<h:inputText id="email" value="#{customer.email}" />
		<br />

		<br />
		<br />
		<h:commandButton action="#{customerImpl.addCustomerDao(customer)}"
			value="Send Otp" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
		<br />
		<br />
		<h:outputText value="#{signinError}" />
	</h:form>
</body>
	</html>

</f:view>