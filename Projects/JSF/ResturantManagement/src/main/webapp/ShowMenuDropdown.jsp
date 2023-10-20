<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h:selectOneMenu id="restaurantSelected" value="#{resDao.localCode}" onchange="submit()"				
		valueChangeListener="#{resDao.restaurantLocaleCodeChanged}">
		<f:selectItems value="#{resDao.showRestaurantNames()}" />
	</h:selectOneMenu>
	<br/><br/>
	<h:outputText value="#{menuDao.showMenu(resDao.localCode)}" />
	 <center>
        <h:dataTable value="" var="e" border="5">
        	          <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="menid" />
        	           </f:facet>
                    <h:outputText value="#{e.menid}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="MEN_ITEM" />
        	           </f:facet>
                    <h:outputText value="#{e.menitem}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="MEN_PRICE" />
        	           </f:facet>
                    <h:outputText value="#{e.menprice}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="Restaurant_ID" />
        	           </f:facet>
                    <h:outputText value="#{e.restaurantid}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="MEN_CALORIES" />
        	           </f:facet>
                    <h:outputText value="#{e.mencalories}"/>
                </h:column>
        	    <h:column>
                     <f:facet name="header">
        	           		<h:outputText value="MEN_SPECIALITY" />
        	           </f:facet>
                    <h:outputText value="#{e.menspeciality}"/>
                </h:column>
        </h:dataTable>
        </center>
	
</body>
</html>
</f:view>