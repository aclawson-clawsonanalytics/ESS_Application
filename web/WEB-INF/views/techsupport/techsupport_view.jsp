<%-- 
    Document   : tech_support_view
    Created on : Jun 12, 2016, 7:53:34 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%> 

<html>
<link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/foundation.css"/>
<link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/app.css"/>
<!DOCTYPE html>
<body>
    <div class="row header">
            <div class="small-12 columns" align="center">
                <jsp:include page="/WEB-INF/fragments/header.jsp"/>
            </div>
        </div>
        
        <div class="row">
                
                    <jsp:include page="/WEB-INF/views/startup/fragments/login_menu.jsp"/>
            </div>
            <div class="row techsupport-form">
                
            </div>
     <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
<script>
      $(document).foundation();
    </script>
</body>
</html>
