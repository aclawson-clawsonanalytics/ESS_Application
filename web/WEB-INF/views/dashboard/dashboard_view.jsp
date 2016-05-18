<%-- 
    Document   : dashboard_view
    Created on : May 18, 2016, 3:05:56 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/foundation.css"/>
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/app.css"/>
        
        <title>MAX Dashboard</title>
        
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <div class="row header">
            <div class="large-12 columns" align="center">
                <jsp:include page="/WEB-INF/jsp/tiles/header.jsp"/>
            </div>
        </div>
            
        <div class="row">
            <div class="large-4 columns" align="center">
                <jsp:include page="/WEB-INF/jsp/tiles/dashboard_menu.jsp"/>
            </div>
            <div class="large-8 columns">
                <!--Startup Content here-->
                <h1>Dashboard Content here</h1>
            </div>
        </div>
    </body>
</html>
