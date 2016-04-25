<%-- 
    Document   : registrationRequest_view
    Created on : Apr 22, 2016, 8:42:27 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="foundation.css"/>
        <title>Subscribe</title>
    </head>
    <body>
        <div class="row" style="height:300px">
            <div class="large-6 large-centered columns">
                <jsp:include page="/WEB-INF/views//registration_request/registrationForm_content.jsp"/>
            </div>
        </div>
            
            <div class="row">
                <jsp:include page="/WEB-INF/jsp/tiles/footer.jsp"/>
            </div>
        
            
    </body>
</html>
