<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order History</title>
</head>
<body>
	<h:dataTable value="#{ordersHistory}" var="e" border="5">
		<h:column>
			<f:facet name="header">
				<h:outputText value="ORD_ID" />
			</f:facet>
			<h:outputText value="#{e.ordid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="CusId" />
			</f:facet>
			<h:outputText value="#{e.cusid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="VenId" />
			</f:facet>
			<h:outputText value="#{e.venid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="WAL SOURCE" />
			</f:facet>
			<h:outputText value="#{e.walsource}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="MenId" />
			</f:facet>
			<h:outputText value="#{e.menid}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="OrdDate" />
			</f:facet>
			<h:outputText value="#{e.orddate}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="ORD STATUS" />
			</f:facet>
			<h:outputText value="#{e.ordstatus}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="ORD COMMENTS" />
			</f:facet>
			<h:outputText value="#{e.ordcomments}" />
		</h:column>
	</h:dataTable>
</body>
</html>
</f:view>