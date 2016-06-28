<%-- 
    Document   : info_bar
    Created on : Jun 11, 2016, 7:20:06 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div id="info_bar" class="top-bar">
        <div class="top-bar-right">
            <ul class="menu info-bar-menu">
                <!--
                <li style="padding:10px">
                    <b>Account: </b>${pageContext.session.getAttribute('account').getName()}
                </li>
                <li style="padding:10px">
                    <b>Campus: </b>${pageContext.session.getAttribute('campus').getName()}
                </li>
                -->
                <li style="padding:10px">
                    <b>User: </b>${pageContext.session.getAttribute('activeUser').getEmail()}
                </li>            
                
            </ul>
        </div>
    </div>
</html>
