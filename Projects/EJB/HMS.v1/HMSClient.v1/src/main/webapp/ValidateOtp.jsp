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
		<h2>
	<h:outputText value="Validate Otp" />
	</h2>
	<h:form id="form">
		<h:outputText value="UserName " />
	<h:inputText id="uname" value="#{hibpatient.username}" /><br/> 

	<h:outputText value="Otp " />
	<h:inputText id="otpString" value="#{hibpatient.otpString}" /><br/>
	
	<h:outputText value="Password " />
	<h:inputText id="pass" value="#{hibpatient.password}" /><br/> 
	
	<br/><br/>
	<h:commandButton action="#{patienteImpl.validateOtp(hibpatient)}" value="Add" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset"></h:commandButton>
	<br/><br/>
	<h:outputText value="#{otpError}" />
	
	</h:form>
    </body>
</html>
</f:view>