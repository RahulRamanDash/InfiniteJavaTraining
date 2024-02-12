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
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
			background-color: #f5f5f5;
			text-align: center;
		}

		.content {
			display: flex;
			justify-content: center;
			align-items: center;
			width: 100%;
			height: 100%;
		}

		.loader-wrapper {
			width: 100%;
			height: 100%;
			position: absolute;
			top: 0;
			left: 0;
			background-color: #f5f5f5; /* Updated background color */
			display: flex;
			justify-content: center;
			align-items: center;
		}

		.loader {
			display: inline-block;
			width: 50px;
			height: 50px;
			position: relative;
			border: 4px solid #333; /* Updated border color */
			animation: loader 2s infinite ease;
		}

		.loader-inner {
			vertical-align: top;
			display: inline-block;
			width: 100%;
			background-color: #333; /* Updated background color */
			animation: loader-inner 2s infinite ease-in;
		}

		@keyframes loader {
			0% { transform: rotate(0deg); }
			25% { transform: rotate(180deg); }
			50% { transform: rotate(180deg); }
			75% { transform: rotate(360deg); }
			100% { transform: rotate(360deg); }
		}

		@keyframes loader-inner {
			0% { height: 0%; }
			25% { height: 0%; }
			50% { height: 100%; }
			75% { height: 100%; }
			100% { height: 0%; }
		}

		h2 {
			color: #333;
			margin-top: 20px;
		}

		table {
			text-align: center;
			width: 100%;
			margin-top: 20px;
			border-collapse: collapse;
		}

		table, th, td {
			border: 1px solid #333;
		}

		th {
			background-color: #333;
			color: #fff;
			padding: 10px;
		}

		td {
			padding: 10px;
		}

		table, th, td {
			border: 0px solid #333;
		}

		a {
			color: white;
			text-decoration: none;
		}

		.button-container {
			display: flex;
			justify-content: center;
			margin-top: 10px;
		}

		.loader-wrapper {
			background-color: #f5f5f5; /* Updated background color */
		}

		.loader {
			border-color: #333;
		}

		.loader-inner {
			background-color: #333; /* Updated background color */
		}

		#form {
			margin: 10px auto;
			background-color: #fff; /* Updated background color */
			padding: 20px; /* Added padding */
			border-radius: 8px; /* Added border-radius for a rounded look */
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Added box-shadow for a subtle shadow */
		}

		#form input[type="text"], #form select {
			padding: 10px;
			margin-bottom: 10px;
			width: 20%;
			box-sizing: border-box;
			border: 1px solid #ccc;
			border-radius: 4px;
			outline: none;
		}

		#form .button-container button {
			background-color: #333; /* Updated background color */
			color: #fff;
			padding: 10px 20px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			transition: background-color 0.3s; /* Added transition for a smooth hover effect */
		}

		#form .button-container button:hover {
			background-color: #555; /* Updated background color on hover */
		}
		.paginationBut{
			display: flex;
	        justify-content: flex-end;
	        margin-right: 45px;
	        margin-top: 10px;
	        
	        margin-top: 10px;
		}
		.redio-container {
    display: flex;
    align-items: center;
}
#filter-label {
}
	</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div class="loader-wrapper">
    <span class="loader"><span class="loader-inner"></span></span>
</div>
<script>
	  $(document).ready(function () {
			        toggleRadioVisibility();
			        $(".loader-wrapper").fadeOut("slow");
			    });
</script>
	<h:form id="form">
		<h2>
			<h:outputText value="Manage Appointments" />
		</h2>

		<h:outputText value="Search By : " />

		<h:selectOneMenu id="searchType" value="#{appointmentImpl.searchType}"
			onchange="clearInputText(); submit();"
			valueChangeListener="#{appointmentImpl.searchTypeChanged}">
			<f:selectItems value="#{appointmentImpl.getsearchTypes()}" />
		</h:selectOneMenu>
		<br/>
		<h:selectOneRadio id="radio" value="#{appointmentImpl.searchMethod}"
			style=" float: center;
   width: auto; margin-left: 500px;">
			<f:selectItem itemValue="Contains" itemLabel="Contains" />
			<f:selectItem itemValue="StartsWith" itemLabel="Starts With" />
		</h:selectOneRadio>
		<br/>
		<h:outputText id="searchLable" value="#{searchLable}" />
		<h:inputText id="searchValue" value="#{appointmentImpl.searchValue}"/>
			&nbsp;
			<div class="button-container">
				<h:commandButton
				action="#{pageDao.getPatientAppointmentListNew(appointmentImpl.searchValue, appointmentImpl.searchMethod)}"
				value="Search" id="search"/>
				&nbsp;
				<h:commandButton action="ShowPatientAppointmentNew" id="reset" value="Reset" />
			</div>
		<br />
		<br />
		<h:dataTable
			value="#{pageDao.getPatientAppointmentListNew(appointmentImpl.searchValue, appointmentImpl.searchMethod)}"
			var="appointment" border="3">
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{appointmentImpl.sortByAppointmentId()}" value="Appointment Id" />
				</f:facet>
				<h:commandLink style="color: black;" action="#{ejbImpl.searchEmploy(appointment.appointmentId)}" value="#{appointment.appointmentId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{appointmentImpl.sortByPatientId()}" value="Patient Id" />
				</f:facet>
				<h:outputText value="#{appointment.uhid}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink id="editLink" action="#{appointmentImpl.sortByFirstName()}" value="Fast Name" />
				</f:facet>
				<h:outputText value="#{appointment.firstName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{appointmentImpl.sortByLastName()}" value="Last Name" />
				</f:facet>
				<h:outputText value="#{appointment.lastName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{appointmentImpl.sortByAppointmentDate()}" value="Appointment Date" />
				</f:facet>
				<h:outputText
					value="#{appointment.appointmentDate.toString().substring(0,10)}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:commandLink action="#{appointmentImpl.sortByAppointmentTime()}" value="Appointment Time" />
				</f:facet>
				<h:outputText value="#{appointment.appointmentTime}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="View Appointment" />
				</f:facet>
				<h:commandButton
					action="#{appointmentImpl.redirectToAppointmentDetails(appointment.appointmentId, appointment.uhid)}"
					value="View Appointment" onclick="showAlert()"/>
			</h:column>
		</h:dataTable>
		<br />
		<h:outputLabel value="#{notFoundErr}" />
		<!--The paging buttons-->
		<div class="paginationBut">
			<h:commandButton value="first" action="#{pageDao.pageFirst}"
				disabled="#{pageDao.firstRow == 0}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="prev" action="#{pageDao.pagePrevious}"
				disabled="#{pageDao.firstRow == 0}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="next" action="#{pageDao.pageNext}"
				disabled="#{pageDao.firstRow + pageDao.rowsPerPage >= pageDao.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="last" action="#{pageDao.pageLast}"
				disabled="#{pageDao.firstRow + pageDao.rowsPerPage >= pageDao.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:outputText
				value="Page #{pageDao.currentPage} / #{pageDao.totalPages}" />
		</div>

		<script type="text/javascript">
			function clearInputText() {
				var inputText = document.getElementById('form:searchValue');
				if (inputText) {
					inputText.value = '';
				}
				toggleRadioVisibility();
			}

			  function toggleRadioVisibility() {
			        var searchType = document.getElementById('form:searchType');
			        var searchValue = document.getElementById('form:searchValue');
			        var searchLable = document.getElementById('form:searchLable');
			        var radio = document.getElementById('form:radio');
			        var search = document.getElementById('form:search');
			        var reset = document.getElementById('form:reset');
			        
			            
			        if (searchType.value === 'Select') {
			            radio.style.display = 'none';
			            searchValue.hidden = true;;
			            searchLable.hidden = true;;
			            search.hidden = true;;
			            reset.hidden = true;;
			        } else {
			            radio.style.display = 'block';
			            searchValue.hidden = false;;
			            searchLable.hidden = false;;
			            search.hidden = false;;
			            reset.hidden = false;;
			        }
			    }

		</script>
	</h:form>
</body>
	</html>
</f:view>