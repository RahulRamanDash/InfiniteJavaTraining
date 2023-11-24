<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
 <link href="./resources/css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h:form>
		<h2>
			<h:outputText value="Update Patient Appointment" />
		</h2>
		<br />

		Appointment Id : 
		<h:inputText value="#{editAppointment.appointmentId}"/>
		<br/>
		Patient Id : 
		<h:inputText value="#{editAppointment.uhid}"/>
		<br/>
				First Name : 
		<h:inputText value="#{editAppointment.firstName}"/>
		<br/>

		Last Name : 
		<h:inputText value="#{editAppointment.lastName}"/>
		<br/>
		
		Appointment Date : 
		<h:inputText id="dob-id" value="#{editAppointment.appointmentDate}" converterMessage="Please provide date of birth in dd/mm/yyyy format">  
		<f:convertDateTime pattern="yyyy/MM/dd" />  
		</h:inputText>
		<br/>
		
		Appointment Time : 
		<h:inputText value="#{editAppointment.appointmentTime}"/>
		<br/>
		
		<h:commandButton action="#{ejbImpl.updateEmployEjb(editAppointment)}" value="Update" />

	</h:form>
</body>
	</html>
</f:view>
