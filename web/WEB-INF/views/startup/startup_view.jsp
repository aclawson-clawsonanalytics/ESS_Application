<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>

<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <style>
            
        </style>
        <div id="mainImage" class="row" style="height:200px"/>
        <img src="/WEB-INF/resources/images/vital.jpg" style="width:100%;height:200px" alt="Logo"/>
            
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
