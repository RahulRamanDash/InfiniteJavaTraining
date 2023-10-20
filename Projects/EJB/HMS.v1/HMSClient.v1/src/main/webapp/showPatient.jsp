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
		</center>
		<h:dataTable value="#{patientejbImpl.showPatientEjb()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Patient Id" />
				</f:facet>
				<h:outputText value="#{e.pid}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Patient Name" />
				</f:facet>
				<h:outputText value="#{e.name}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="UserName" />
				</f:facet>
				<h:outputText value="#{e.username}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Age" />
				</f:facet>
				<h:outputText value="#{e.age}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Weight" />
				</f:facet>
				<h:outputText value="#{e.weight}" />
			</h:column>
			     <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Gender" />
                    </f:facet>
                    <h:outputText value="#{e.gender}"/>
                </h:column>
                     <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Address" />
                    </f:facet>
                    <h:outputText value="#{e.address}"/>
                </h:column>
                     <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Phone NO" />
                    </f:facet>
                    <h:outputText value="#{e.phoneNo}"/>
                </h:column>
                     <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Disease" />
                    </f:facet>
                    <h:outputText value="#{e.disease}"/>
                </h:column>
                <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Doctor_Id" />
                    </f:facet>
                    <h:outputText value="#{e.doctorId}"/>
                </h:column>
		</h:dataTable>
		
		<h:commandLink action="addPatient" value="Add Patient" />
	</h:form>
</body>
	</html>
</f:view>
