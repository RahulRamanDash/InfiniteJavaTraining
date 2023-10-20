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
				<h:outputText value="Add Agent" />
			</h2>
		</center>
		<h:outputText value="Agent Name" />
		<h:inputText value="#{agent.name}" />
		<br />
		<h:outputText value="City" />
		<h:inputText value="#{agent.city}" />
		<br />
		<h:outputText value="Gender" />
		<h:inputText value="#{agent.gender}" />
		<br />
		<h:outputText value="MaritalStatus" />
		<h:inputText value="#{agent.maritalstatus}" />
		<br />
		<h:outputText value="Premium" />
		<h:inputText value="#{agent.premium}" />
		<br />
		<h:commandButton action="#{ejbImpl.addAgentEjb(agent)}"
			value="Add" />
	</h:form>
</body>
	</html>
</f:view>
