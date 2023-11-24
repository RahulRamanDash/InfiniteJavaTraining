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
            <br/>
            <h:outputText value="#{}" />
             <br/>
			<h:commandButton action="#{ejbImpl.sayHelloEjb()}" value="Hi"></h:commandButton>
        </h:form>
    </body>
    </html>
</f:view>
