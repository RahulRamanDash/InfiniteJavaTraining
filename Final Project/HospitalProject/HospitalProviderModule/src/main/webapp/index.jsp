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
	
	
	
</style>
</head>
<body>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Patient Appointment" />
			</h2>
		<h:commandButton action="#{pageDao.getPatientAppointmentListNew()}" value="Show Appointment"/>
		</center>
	</h:form>
</body>
	</html>
</f:view>
