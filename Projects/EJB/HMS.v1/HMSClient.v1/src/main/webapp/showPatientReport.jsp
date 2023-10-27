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
				<h:outputText value="Patient Report's" />
			</h2>
		</center>
		<h:dataTable value="#{controller.showPatientReport()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Report Id" />
				</f:facet>
				<h:outputText value="#{e.reportId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Patient Id" />
				</f:facet>
				<h:outputText value="#{e.pid}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Test Code" />
				</f:facet>
				<h:outputText value="#{e.testCode}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Test Name" />
				</f:facet>
				<h:outputText value="#{e.testName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Test Description" />
				</f:facet>
				<h:outputText value="#{e.testDescription}" />
			</h:column>
			     <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Cost" />
                    </f:facet>
                    <h:outputText value="#{e.cost}"/>
                </h:column>
                     <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Comments" />
                    </f:facet>
                    <h:outputText value="#{e.comments}"/>
                </h:column>
		</h:dataTable>
		
		<h:commandLink action="addPatientReport" value="Add Patient Report" />
	</h:form>
</body>
	</html>
</f:view>