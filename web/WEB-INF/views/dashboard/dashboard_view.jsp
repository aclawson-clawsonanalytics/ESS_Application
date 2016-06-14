<%-- 
    Document   : dashboard_view
    Created on : May 18, 2016, 3:05:56 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/foundation.css"/>
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/app.css"/>
        <!--<script src="WEB-INF/resources/js/dashboard.js"/>-->
        <script src="/styles/foundation-6.2.1-complete/js/vendor/jquery.js"></script>
        
        <title>MAX Dashboard</title>
        
        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>
        <div class="row header">
            <div class="small-12 columns" align="center">
                <jsp:include page="/WEB-INF/fragments/header.jsp"/>
            </div>
        </div>
            <div class="row">
                <jsp:include page="/WEB-INF/views/dashboard/fragments/dashboard_topbar.jsp"/>
            </div>
            <!--
        <div class="row">
            <div class="dashboard_content">
                <div class="small-12 columns">
                    
                    <h1 id="contentBody">Dashboard Content here</h1>
                </div>
            </div>
        </div>
            -->
        <div class="row" align="center">
            <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
        </div>
    
        <script src="js/dashboard.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
    
    <script>
      $(document).foundation();
    </script>
    
    </body>
</html>
