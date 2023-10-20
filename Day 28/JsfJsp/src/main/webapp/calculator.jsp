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
			<h:outputText value="Restaurant Management" />
			</h2>
			<h:dataTable value="#{impl.showRestaurantsDao()}" var="e" border="3">
			<h:column>
			<f:facet name="header">Restaurant_ID : </f:facet>
			<h:outputText value="#{e.Restaurant_ID}" />
			</h:column>
			<h:column>
			<f:facet name="header">Restaurant_Name</f:facet>
			<h:outputText value="#{e.Restaurant_Name}" />
			</h:column>
			<h:column>
			<f:facet name="header">Branch</f:facet>
			<h:outputText value="#{e.Branch}" />
			</h:column>
			<h:column>
			<f:facet name="header">City</f:facet>
			<h:outputText value="#{e.City}" />
			</h:column>
			<h:column>
			<f:facet name="header">MobileNo</f:facet>
			<h:outputText value="#{e.MobileNo}" />
			</h:column>
			<h:column>
			<f:facet name="header">Email</f:facet>
			<h:outputText value="#{e.Email}" />
			</h:column>
			<h:column>
			<f:facet name="header">Rating</f:facet>
			<h:outputText value="#{e.Rating}" />
			</h:column>
			</h:dataTable>
			</center>
			</h:form>
    </body>
</html>
</f:view>