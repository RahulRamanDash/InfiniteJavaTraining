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
           <jsp:include page="Menu.jsp"/>
        <center>
                <h2><h:outputText value="Select Insurance"/></h2>
            </center>
    <h:dataTable value="#{pageDao.getEmployList()}" var="e"
			border="3">
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Id" />
				</f:facet>
				<h:outputText value="#{e.insuranceId}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Insurance Name" />
				</f:facet>
				<h:outputText value="#{e.insuranceName}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputLabel value="Take Policy" />
				</f:facet>
				<h:commandButton action="#{planImpl.redirectToInsurancePlan(e.insuranceId)}" value="Show Policy" />
			</h:column>
			</h:dataTable>
			
         <!--The paging buttons-->
            <h:commandButton value="first" action="#{pageDao.pageFirst}"
                             disabled="#{pageDao.firstRow == 0}" />
            <h:commandButton value="prev" action="#{pageDao.pagePrevious}"
                             disabled="#{pageDao.firstRow == 0}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{pageDao.pageNext}"
                             disabled="#{pageDao.firstRow + pageDao.rowsPerPage >= pageDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{pageDao.pageLast}"
                             disabled="#{pageDao.firstRow + pageDao.rowsPerPage >= pageDao.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:outputText value="Page #{pageDao.currentPage} / #{pageDao.totalPages}" />
            <br />
        </h:form>
    </body>
</html>
</f:view>
