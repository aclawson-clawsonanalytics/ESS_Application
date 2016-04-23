<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
    
    <head>
        <link REL='stylesheet' TYPE='text/css' HREF='/resources/styles/theme1.css'/>
        <link REL='stylesheet' TYPE='text/css' HREF='/foundation/css/foundation.css'/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <style>
            @import url('/foundation/css/foundation.css');
            @import url('/resources/styles/theme1.css');
        </style>
        <div id="mainImage" class="row" style="height:200px"/>
        <style>
            #mainImage
            {
                background-image:url("/resources/images/vitals.jpg");
            }
        </style>
            
        </div>
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
