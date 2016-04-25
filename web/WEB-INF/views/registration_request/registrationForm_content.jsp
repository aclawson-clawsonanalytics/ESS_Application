<%-- 
    Document   : registrationForm_content
    Created on : Apr 24, 2016, 1:38:31 AM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/general/formComponents.css"/>
    </head>
    <form action="#" method="POST">
    <div class="large-6 columns">
        
        
        <b>Account Manager</b><br>
        First name: <input type="text" name="accountFirst"><br>
        Last name: <input type="text" name="accountLast"><br>
        Email: <input type="text" name="accountEmail">
        Password: <input type="text" name="accountPassword">
    </div>
    <div class="large-6 columns">
        <b>District Information</b><br>
        District name: <input type="text" name="districtName"><br>
        Phone: <input type="text" name="districtPhone"><br>
        Fax: <input type="text" name="districtFax"><br>
        <input type="submit" value="Submit"/>
    </div>
    </form>
</html>
