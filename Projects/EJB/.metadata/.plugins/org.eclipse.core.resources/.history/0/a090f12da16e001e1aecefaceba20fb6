<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            align-items: center;
            margin: 0;
        }
    </style>
</head>
<body>

		<h2>
			<h:outputText value="Admit Patient" />
		</h2>
		<h:form id="form">
			<h:outputText value="Patient Id " />
			<h:inputText id="name" value="#{patientId}" />
			<br />

			<h:selectOneMenu id="roomType" value="#{roomMasterEjbImpl.roomType}"
				onchange="submit()"
				valueChangeListener="#{roomMasterEjbImpl.roomTypeChanged}">
				<f:selectItems value="#{roomMasterEjbImpl.showRoomTypeEjb()}" />
			</h:selectOneMenu>
				
			<h:outputText id="type" value="#{roomMasterEjbImpl.roomType}" />
			<br/><br/>
			<h:selectOneMenu id="roomAvail" value="#{roomMasterEjbImpl.roomNo}"
				onchange="submit()"
				valueChangeListener="#{roomMasterEjbImpl.roomNoChanged}">
				<f:selectItems value="#{roomMasterEjbImpl.showRoomNoEjb(roomMasterEjbImpl.roomType)}" />
			</h:selectOneMenu>
			<h:outputText id="roomNo" value="#{roomMasterEjbImpl.roomNo}" />
		</h:form>
</body>
	</html>

</f:view>