<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition template="classicTemplate">
        <tiles:putAttribute name="title" value="Startup"/>
        <tiles:putAttribute name="content" value="/jsp/startup_content.jsp"/>
        <tiles:putAttribute name="side_menu" value="/tiles/login_menu.jsp"/>
        <tiles:putAttribute name="header" value="/jsp/tiles/header.jsp"/>
        <tiles:putAttribute name="footer" value="/jsp/tiles/footer.jsp"/>
        <tiles:putAttribute name="content" value="/jsp/views/startup/startup_content"/>
</tiles:insertDefinition>
