<%-- 
    Document   : user_data
    Created on : Jun 10, 2016, 6:44:29 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <b>User: </b>${pageContext.session.getAttribute("activeUser").getEmail()}<br>
    <b>Account: </b>${pageContext.session.getAttribute("activeUser").Account().getName()}<br>
    <b>Campus: </b>${pageContext.session.getAttribute("activeUser").Campus().getName()}
</html>
