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
        	<h:outputText value="Employ No : #{employFound.empno}"/>
        	<br/>
        	<h:outputText value="Employ Name : #{employFound.name}"/>
        	<br/>
        	<h:outputText value="Gender : #{employFound.gender}"/>
        	<br/>
        	<h:outputText value="Dept : #{employFound.dept}"/>
        	<br/>
        	<h:outputText value="Desig : #{employFound.desig}"/>
        	<br/>
        	<h:outputText value="Basic : #{employFound.basic}"/>
        </h:form>
        </center>
    </body>
</html>
</f:view>