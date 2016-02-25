<%-- 
    Document   : RegistrationRequest
    Created on : Feb 25, 2016, 12:43:41 AM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Request Form</title>
    </head>
    <body>
        <h1>Registration Request Form:</h1>
        <html:form action="/SubmitRegistration">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Manager First Name: </td>
                        <td><html:text property="FirstName" /></td>
                    </tr>
                    <tr>
                        <td>Manger Last Name: </td>
                        <td><html:text property="LastName" /></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><html:text property="Email" /></td>
                    </tr>
                    <tr>
                        <td>Phone: </td>
                        <td><html:text property="Phone" /></td>
                    </tr>
                    <tr>
                        <td>Fax: </td>
                        <td><html:text property="Fax" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><html:text property="Password" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password: </td>
                        <td><html:text property="ConfirmPassword" /></td>
                    </tr>
                    
                </tbody>
            </table>

            <html:submit value="Submit Registration" />
        </html:form>
    </body>
</html>
