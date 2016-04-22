<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
    
    <head>
        <link REL='stylesheet' TYPE='text/css' HREF='theme1.css'/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <style>
            @import url('foundation.css');
            @import url('theme1.css');
        </style>
        <div class="row">
            <div class="large-12 columns" align="center">
                <jsp:include page="/WEB-INF/jsp/tiles/header.jsp"/>
            </div>
        </div>
        
            <div class="row">
                <div class="large-3 columns" align="center">
                    <jsp:include page="/WEB-INF/jsp/tiles/login_menu.jsp"/>
                </div>
                <div class="large-8 columns">
                    
                </div>
            </div>
            
                <div class="row" align="center">
                    <jsp:include page="/WEB-INF/jsp/tiles/footer.jsp"/>
                </div>
                
                
        
        
    </body>
</html>
