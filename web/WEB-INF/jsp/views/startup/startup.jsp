<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/foundation/css/foundation.css">
        <title><tiles:insertAttribute name="title"/></title>
    </head>
    <body>
        <tiles:insertDefinition name="homepage">
            <tiles:putAttribute name="content" value="/WEB-INF/jsp/views/startup/startup_content.jsp"/>
            <tiles:putAttribute name="side_menu" value="/WEB-INF/jsp/tiles/login_menu.jsp"/>
        </tiles:insertDefinition>
         
    </body>
</html>
