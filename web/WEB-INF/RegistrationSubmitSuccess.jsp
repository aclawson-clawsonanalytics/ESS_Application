<%-- 
    Document   : RegistrationSubmitSuccess
    Created on : Feb 27, 2016, 7:28:33 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Submission Success</title>
    </head>
    <body>
        <h1>Your request for registration with SMSYS has been received.</h1>
        <p>You will be contacted by a representative shortly.</p>
        <p>An email will be sent to: 
            <bean:write name="RegistrationRequestForm" property="email"/></p>
    </body>
</html>
