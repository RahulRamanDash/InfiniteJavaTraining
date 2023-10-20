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
                <h2><h:outputText value="Agent Records"/></h2>
        <h:dataTable value="#{ejbImpl.showAgentEjb()}" var="e" border="3">
              	    <h:column>
                    <f:facet name="header">
                    	<h:outputLabel value="Agent Id" />
                    </f:facet>
                    <h:outputText value="#{e.agentid}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Agent Name" />
                    </f:facet>
                    <h:outputText value="#{e.name}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="City" />
                    </f:facet>
                    <h:outputText value="#{e.city}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Gender" />
                    </f:facet>
                    <h:outputText value="#{e.gender}"/>
                </h:column>
                    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="MaritalStatus" />
                    </f:facet>
                    <h:outputText value="#{e.maritalstatus}"/>
                </h:column>
                 <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Premium" />
                    </f:facet>
                    <h:outputText value="#{e.premium}"/>
                </h:column>
				    <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Search" />
                    </f:facet>
                    <h:commandButton action="#{ejbImpl.searchAgentEjb(e.agentid)}" value="Search"/>
                </h:column>
                <h:column>
                     <f:facet name="header">
                    	<h:outputLabel value="Delete" />
                    </f:facet>
                    <h:commandButton action="#{ejbImpl.deleteAgentEjb(e.agentid)}" value="Delete"/>
                </h:column>
        </h:dataTable>
                    <h:commandButton action="addAgent.jsp?faces-redirect=true" value="Add Agent"/>
            </center>
        </h:form>
    </body>
</html>
</f:view>
