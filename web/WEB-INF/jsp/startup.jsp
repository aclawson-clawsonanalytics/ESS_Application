<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/foundation/css/foundation.css">
        <title>Login</title>
    </head>
    <body>
            
    <tiles:insert definition="classicTemplate">
        <tiles:put-attribute name="content" value="/jsp/startup_content.jsp"/>
        <tiles:put-attribute name="side_menu" value="/tiles/login_menu.jsp"/>
    </tiles:insert>
    </body>
</html>
