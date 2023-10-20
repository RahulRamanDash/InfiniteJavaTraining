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
	<h:outputText value="Patient Id " />
	<h:inputText id="pid" value="#{hibpatient.pid}" /><br/> 
	
	<h:outputText value="Patient Name " />
	<h:inputText id="name" value="#{hibpatient.name}" /><br/> 
	
		<h:outputText value="UserName " />
	<h:inputText id="uname" value="#{hibpatient.username}" /><br/> 
	
		<h:outputText value="Email Id " />
	<h:inputText id="email" value="#{hibpatient.email}" /><br/> 
	
	<h:outputText value="Age " />
	<h:inputText id="age" value="#{hibpatient.age}" /><br/> 
	
	<h:outputText value="Weight " />
	<h:inputText id="Weight" value="#{hibpatient.weight}" /><br/> 

	<h:outputText value="gender " />
	<h:inputText id="gender" value="#{hibpatient.gender}" /><br/> 

	<h:outputText value="address " />
	<h:inputText id="address" value="#{hibpatient.address}" /><br/> 

	<h:outputText value="phoneno " />
	<h:inputText id="phoneno" value="#{hibpatient.phoneNo}" /><br/> 

	<h:outputText value="disease " />
	<h:inputText id="disease" value="#{hibpatient.disease}" /><br/> 

	<h:outputText value="Doctor Id " />
	<h:inputText id="Doctorid" value="#{hibpatient.doctorId}" /><br/>
	
	<br/><br/>
	<h:commandButton action="#{patienteImpl.addPatientDao(hibpatient)}" value="Send Otp" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	
	</h:form>
</center>
    </body>
</html>

</f:view>