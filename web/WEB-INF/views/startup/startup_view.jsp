<%-- 
    Document   : startup
    Created on : Apr 9, 2016, 8:01:51 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/foundation.css"/>
        <link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/app.css"/>

        <title>Welcome</title>

        <!--<link rel="stylesheet" type="text/css" href="/resources/stylesheet.css"/>-->
    </head>
    <body>

        

        <div class="row startup-header">
            <div class="small-12 columns" align="center">
                <jsp:include page="/WEB-INF/fragments/header.jsp"/>
            </div>
        </div>

            <div class="row">
                    <jsp:include page="/WEB-INF/views/startup/fragments/login_menu.jsp"/>
            </div>
            

                <div class="row footer" align="center">
                    <jsp:include page="/WEB-INF/fragments/footer.jsp"/>
                </div>


                <script src="js/login.js"></script>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
<script>
      $(document).foundation();
    </script>
    </body>
</html>
