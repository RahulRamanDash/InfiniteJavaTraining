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
   <jsp:include page="Menu.jsp"/>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Customer Details" />
			</h2>
		<h:dataTable value="#{customerImpl.showCustomerDetails()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Customer Id" />
				</f:facet>
				<h:outputText value="#{e.custId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="First Name" />
				</f:facet>
				<h:outputText value="#{e.firstName}" />
			</h:column>			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Last Name" />
				</f:facet>
				<h:outputText value="#{e.lastName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Gender" />
				</f:facet>
				<h:outputText value="#{e.gender}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Dob" />
				</f:facet>
				<h:outputText value="#{e.dateOfBirth}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="UserName" />
				</f:facet>
				<h:outputText value="#{e.userName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Email" />
				</f:facet>
				<h:outputText value="#{e.email}" />
			</h:column>
			</h:dataTable>
			
		</center>
	</h:form>
</body>
	</html>
</f:view>
