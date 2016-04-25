<%-- 
    Document   : submissionSuccess_view
    Created on : Apr 25, 2016, 12:22:58 AM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="text/css" href="/styles/foundation/foundation.css"/>
        <link rel="text/css" href="/styles/general/formComponents/css"/>
        <title>Submission Success</title>
    </head>
    
    <body>
        <div id="mainImage" class="row" style="height:200px"/>
        <img src="/WEB-INF/resources/images/vital.jpg" style="width:100%;height:200px" alt="Logo"/>
            
        </div>
            
        
        <div class="row" style="height:300px">
            <div class="large-6 large-centered columns">
                <h2>Congratulations!</h2><br> <br>
                
                Your registration request was submitted! A representative of
                <app:AppName/> will review your request and you will receive an
                email upon approval.<br>
                <br>
                Thank you for choosing <app:AppName/> for your school management
                needs! Click <a href="${pageContext.request.contextPath}/startup.htm">here</a>
                to return to the login page.
                
            </div>
        </div>
            <div class="row">
                <div class="large-12 large-centered" style="padding:100px">
                    <jsp:include page="/WEB-INF/jsp/tiles/footer.jsp"/>
                </div>
            </div>
        
    </body>
</html>
