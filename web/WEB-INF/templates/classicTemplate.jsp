<%-- 
    Document   : classicTemplate
    Created on : Apr 8, 2016, 8:12:38 PM
    Author     : andrewclawson
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/foundation/css/foundation.css">
        
    </head>
    <body>
        <div class="row">
            <tiles:insertAttribute name="header"/>
        </div>
        
        <div class="row">
            <div class="large-3 columns">
                <tiles:insertAttribute name="side_menu"/>
            </div>
            <div class="large-9 columns">
                <tiles:insertAttribute name="content"/>
            </div>
                 
        </div>
        <div class="row">
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
