<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            body {
                text-align: center; /* Center text within the body */
                margin: 0 auto; /* Center the body horizontally */
            }
        </style>
    </head>
    <body>
        <h:form>
            <h2>
                <h:outputText value="Insurance Management System" />
                <br/>
                <h:outputText value="Customer Dashboard"/>
            </h2>
            <br/>
            <b>
            <h:outputText value="Welcome #{loggedUser}" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <h:commandButton action="#{customerImpl.customerLogout()}" value="Logout"></h:commandButton>
            </b>
             <br/>
        </h:form>
        <jsp:include page="CustomerMenu.jsp"/>
    </body>
    </html>
</f:view>
