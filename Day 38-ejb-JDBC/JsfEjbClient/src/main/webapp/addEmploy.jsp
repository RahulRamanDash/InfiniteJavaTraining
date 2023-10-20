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
				<h:outputText value="Update Employ" />
			</h2>
		</center>
		<h:outputText value="EmpNo" />
		<h:inputText value="#{employ.empno}" />
		<br />
		<h:outputText value="Employ Name" />
		<h:inputText value="#{employ.name}" />
		<br />
		<h:outputText value="Gender" />
		<h:inputText value="#{employ.gender}" />
		<br />
		<h:outputText value="Dept" />
		<h:inputText value="#{employ.dept}" />
		<br />
		<h:outputText value="Desig" />
		<h:inputText value="#{employ.desig}" />
		<br />
		<h:outputText value="Basic" />
		<h:inputText value="#{employ.basic}" />
		<br />
		<h:commandButton action="#{ejbImpl.addEmployEjb(employ)}"
			value="Add" />
	</h:form>
</body>
	</html>
</f:view>
