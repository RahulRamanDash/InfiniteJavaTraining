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
        <center>
		<h2>
	<h:outputText value="Add Patient" />
	</h2>
	<h:form id="form">
	<h:outputText value="Patient Name " />
	<h:inputText id="name" value="#{patient.name}" /><br/> 
	
	<h:outputText value="Age " />
	<h:inputText id="age" value="#{patient.age}" /><br/> 
	
	<h:outputText value="Weight " />
	<h:inputText id="Weight" value="#{patient.weight}" /><br/> 

	<h:outputText value="gender " />
	<h:inputText id="gender" value="#{patient.gender}" /><br/> 

	<h:outputText value="address " />
	<h:inputText id="address" value="#{patient.address}" /><br/> 

	<h:outputText value="phoneno " />
	<h:inputText id="phoneno" value="#{patient.phoneNo}" /><br/> 

	<h:outputText value="disease " />
	<h:inputText id="disease" value="#{patient.disease}" /><br/> 

	<h:outputText value="Doctor Id " />
	<h:inputText id="Doctorid" value="#{dId}" /><br/> 
	
	<br/><br/>
	<h:commandButton action="#{patientejbImpl.addPatientEjb(patient)}" value="Add" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	
	</h:form>
</center>
    </body>
</html>

</f:view>