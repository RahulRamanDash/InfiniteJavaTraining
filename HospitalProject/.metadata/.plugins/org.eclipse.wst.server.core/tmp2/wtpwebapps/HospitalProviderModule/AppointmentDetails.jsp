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
                    background-color: #f4f4f4;
                    margin: 0;
                    padding: 0;
                    text-align: center;
                }

                .form-container {
                    max-width: 800px; /* Adjust the max-width as needed */
                    margin: 0 auto;
                    background-color: #ffffff; /* Updated background color */
                    padding: 20px;
                    border-radius: 5px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    text-align: left;
                    overflow-x: auto; /* Add this property to enable horizontal scrolling if needed */
                    display: flex;
                    flex-direction: column;
                }

                .custom-button {
                    color: white;
                    padding: 10px 15px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    margin-top: 15px;
                    transition: background-color 0.3s; /* Add smooth transition */
                }

                /* Go Back button styles */
                .go-back-button {
                    background-color: #3498db; /* Default background color */
                }

                .go-back-button:hover {
                    background-color: #2980b9; /* Hover background color */
                }

                /* Confirm button styles */
                .confirm-button {
                	margin-left: 10px;
                    background-color: #2ecc71; /* Default background color */
                }

                .confirm-button:hover {
                    background-color: #27ae60; /* Hover background color */
                }

                /* Cancel button styles */
                .cancel-button {
                	margin-left: 10px;
                    background-color: #e74c3c; /* Default background color */
                }

                .cancel-button:hover {
                    background-color: #c0392b; /* Hover background color */
                }

                /* Add style to the table */
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                }

                th, td {
                    padding: 15px;
                    border: none; /* Remove borders */
                    text-align: left;
                    white-space: nowrap; /* Prevent text wrapping */
                }

                th {
                    color: #4CAF50;
                }

                tr:nth-child(even) {
                    background-color: transparent;
                }

                .button-container {
                    display: flex;
                    justify-content: center;
                    padding: 10px;
                    align-items: center;
                    margin-top: 15px;
                }
            </style>
        </head>
        <body>

            <h:form styleClass="form-container">
                <table>
                    <tr>
                        <th>Appointment Id:</th>
                        <td><h:outputText value="#{appointmentDetail.uhid}" styleClass="form-input" /></td>
                        <th>Name :</th>
                        <td><h:outputText value="#{appointmentDetail.firstName} #{appointmentDetail.lastName}" styleClass="form-input" /></td>
                    </tr>

                    <tr>
                        <th>Dob:</th>
                        <td><h:outputText value="#{enrollmentFound.dob.toString().substring(0,10)}" styleClass="form-input" /></td>
                        <th>Gender:</th>
                        <td><h:outputText value="#{enrollmentFound.gender}" styleClass="form-input" /></td>
                    </tr>

                    <tr>
                        <th><span class="form-label">Appointment Date:</span></th>
                        <td><h:outputText value="#{appointmentDetail.appointmentDate.toString().substring(0,10)}" styleClass="form-input" /></td>
                        <th><span class="form-label">Appointment Time:</span></th>
                        <td><h:outputText value="#{appointmentDetail.appointmentTime}" styleClass="form-input" /></td>
                    </tr>
                </table>

                <div class="button-container">
                    <h:commandButton action="ShowPatientAppointmentNew" value="Go Back" styleClass="custom-button go-back-button" />
                    <h:commandButton action="#{appointmentImpl.confirmAppointment(appointmentDetail.appointmentId)}" value="Confirm" styleClass="custom-button confirm-button"/>
                    <h:commandButton action="#{appointmentImpl.cancelAppointment(appointmentDetail.appointmentId)}" value="Cancel" styleClass="custom-button cancel-button" />
                </div>

                <br />
            </h:form>
        </body>
    </html>
</f:view>
