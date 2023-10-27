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
	<h:outputText value="Add Patient Report" />
	</h2>
	<h:form id="form">
	<h:outputText value="Patient Id " />
	<h:inputText id="pid" value="#{report.pid}" /><br/> 
	
	<h:outputText value="Test Code " />
	<h:inputText id="tcode" value="#{report.testCode}" /><br/> 
	
		<h:outputText value="Test Name " />
	<h:inputText id="tname" value="#{report.testName}" /><br/> 
	
		<h:outputText value="Test Description " />
	<h:inputText id="td" value="#{report.testDescription}" /><br/> 
	
	<h:outputText value="Cost " />
	<h:inputText id="cost" value="#{report.cost}" /><br/> 
	
	<h:outputText value="Comments " />
	<h:inputText id="cmt" value="#{report.comments}" /><br/> 
	
	<br/><br/>
	<h:commandButton action="#{controller.addPatientReport(report)}" value="Submit" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	
	<h:messages /> 
	</h:form>
</center>
    </body>
</html>

</f:view>