<%-- 
    Document   : RegistrationRequest
    Created on : Feb 25, 2016, 12:43:41 AM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Request Form</title>
    </head>
    <body>
        
        <h1>Registration Request Form:</h1>
        <html:form action="/RegistrationRequestForm">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="RegistrationRequestForm"
                                        property="error"
                                        filter="false"/>&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td>Manager First Name: </td>
                        <td><html:text property="firstname" /></td>
                    </tr>
                    <tr>
                        <td>Manger Last Name: </td>
                        <td><html:text property="lastname" /></td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><html:text property="email" /></td>
                    </tr>
                    <tr>
                        <td>District: </td>
                        <td><html:text property="districtname"/></td>
                    </tr>
                    <tr>
                        <td>Phone: </td>
                        <td><html:text property="phone" /></td>
                    </tr>
                    <tr>
                        <td>Fax: </td>
                        <td><html:text property="fax" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><html:text property="password" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password: </td>
                        <td><html:text property="confirmpassword" /></td>
                    </tr>
                    
                </tbody>
            </table>

            <html:submit value="Submit Registration" />
        </html:form>
    </body>
</html>
