<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>

</head>
<body>
        <jsp:include page="CustomerMenu.jsp"/>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Customer Policy" />
			</h2>
		<h:dataTable value="#{policyImpl.showCustomerPolicy(loggedCustId)}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Customer Id" />
				</f:facet>
				<h:outputText value="#{e.custId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Id" />
				</f:facet>
				<h:outputText value="#{e.insuranceId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Plan Id" />
				</f:facet>
				<h:outputText value="#{e.planId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Amount" />
				</f:facet>
				<h:outputText value="#{e.insuranceAmount}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Pay Mode" />
				</f:facet>
				<h:outputText value="#{e.payMode}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Initial Amount" />
				</f:facet>
				<h:outputText value="#{e.initialAmount}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Register Date" />
				</f:facet>
				<h:outputText value="#{e.registerDate}" />
			</h:column>
			</h:dataTable>
		</center>
	</h:form>
</body>
	</html>
</f:view>
