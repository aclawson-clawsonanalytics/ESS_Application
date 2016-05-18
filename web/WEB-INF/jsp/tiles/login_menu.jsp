<%-- 
    Document   : login_menu
    Created on : Apr 9, 2016, 9:40:16 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app" %>

<!DOCTYPE html>
<html>
    
    <div class='side_menu'>
        
        <h2>Login</h2>
        <form action="#">
            <table>
                <tr>
                    <td><b>Email: </td>
                    <td><input type="text"/></td>
                </tr>
                <tr>
                    <td><b>Password: </td>
                    <td><input type="password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
                   
            </table>
            
        </form>
        Click <a href="${pageContext.request.contextPath}/subscribe.htm">here</a> to submit a registration request to subscribe to <app:AppName/>.<br>
    </div>
</html>

