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
	<h:form>
		<center>
			<h2>
				<h:outputText value="Patient Records" />
			</h2>
		<h:dataTable value="#{insuranceEjbImpl.showPatientEjb()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Id" />
				</f:facet>
				<h:outputText value="#{e.insuranceId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Name" />
				</f:facet>
				<h:outputText value="#{e.insuranceName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Take Policy" />
				</f:facet>
				<h:commandButton action="#{policyImpl.redirectToTakePolicy(e.insuranceId)}" value="" />
			</h:column>
			</h:dataTable>
		</center>
	</h:form>
</body>
	</html>
</f:view>
