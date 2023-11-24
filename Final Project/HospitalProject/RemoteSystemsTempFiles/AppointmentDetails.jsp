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
				<h:outputText value="Patient Appointment" />
			</h2>
		<h:dataTable value="#{appointmentImpl.showPatientAppointmentDao()}" var="appointment"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Appointment Id" />
				</f:facet>
				<h:outputText value="#{appointment.appointmentId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Appointment Date" />
				</f:facet>
				<h:outputText value="#{appointment.appointmentDate}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Appointment Time" />
				</f:facet>
				<h:outputText value="#{appointment.appointmentTime}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Patient Id" />
				</f:facet>
				<h:outputText value="#{appointment.uhid}" />
			</h:column>			
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Fast Name" />
				</f:facet>
				<h:outputText value="#{appointment.firstName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Last Name" />
				</f:facet>
				<h:outputText value="#{appointment.lastName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="View Appointment" />
				</f:facet>
				<h:commandButton action="#{appointmentImpl.redirectToAppointmentDetails}" value="View Appointment" />
			</h:column>
			</h:dataTable>
		</center>
	</h:form>
</body>
	</html>
</f:view>
