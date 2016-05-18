<%-- 
    Document   : registrationRequest_view
    Created on : Apr 22, 2016, 8:42:27 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--
        <link rel="stylesheet" href="styles/general/foundation.css"/>
        <link rel="stylesheet" href="styles/general/formComponents.css"/>
        -->
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/foundation.css"/>
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/app.css"/>
        <!--<link rel="stylesheet" href="/foundation-6.2.1-complete/css/app.css"/>-->
        <title>Subscribe</title>
        
    </head>
    <body>
        <div class="row" style="height:150px">
            <div class="large-10 large-centered columns">
                <h3>
                    Welcome to <app:AppName/> by <app:Developer/>!
                </h3>
                <p>
                    We are excited to meet your school management needs. Complete the following form in order to subscribe to <app:AppName/>.
                An email will be sent once your request is approved with the account details included.
                Please contact <a href="#">tech support</a> with any questions.<br> <br>
                If you already have an account and found yourself here on accident, please feel free to visit the
                <a href="${pageContext.request.contextPath}/startup.htm">login</a>.
                </p>
            </div>
        </div>
        <div class="row" style="height:400px; padding:100px">
            <div class="large-12 large-centered columns">
                <jsp:include page="/WEB-INF/views/registration_request/registrationForm_content.jsp"/>
            </div>
        </div>
            
        <div class="row">
            <div class="large-12 large-centered" style="padding:100px">
                <jsp:include page="/WEB-INF/jsp/tiles/footer.jsp"/>
            </div>
        </div>
        
        <script src="js/vendor/jquery.min.js"/>
        <script src="js/vendor/what-input.min.js"/>
        <script src="js/foundation.min.js"/>
    </body>
</html>
