<%-- 
    Document   : account-info_view
    Created on : Jul 19, 2016, 1:37:43 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <!--
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    -->
    
    <body>
        <div class="hide-for-portrait" id="accountInfo-wide-menu" >
            <jsp:include page="/WEB-INF/views/dashboard/account/info/fragments/control_bar.jsp"/>
        </div>
        
        <div class="small-10 small-centered large-8 large-centered">
        <div class="tabs-content" data-tabs-content="account-info-tabs">
            <div class="tabs-panel" id="infoPanel">
                <form>
                    <table>
                        <tr>
                            <td><b>Campus: </b></td>
                            <td><input type="text" name="accountName" value="${account.getName()}"></td>
                        </tr>
                        <tr>
                            <td><b>Open Date: </b></td>
                            <td>${account.getCreationDate()}</td>
                        </tr>
                        <tr>
                            <td><b>Manager: </b></td>
                            <td>
                                ${account.getManagerName()} <a class="button" id="ChangeManagerButton" onclick="showManagerSelector();">Change</a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <select id="managerSelector" name="changeManager">
                                    <option value="-1">Choose a new account manager</option>
                                    
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a class="button" id="SaveAccountInfoChangesButton">Save Changes</a></td>
                        </tr>
                    </table>
                            
                </form>
            </div>
            </div>
            
            <div class="tabs-panel" id="campusesPanel">
                Campuses panel here.
            </div>
        </div>
                            <!--
        <script src="resources/javascript/account.js"></script>
        <script src="resources/javascript/jquery.js"></script>
        <script>
            $(document).ready(function(){
               $("#ChangeManagerButton").hide(); 
            });
        </script>
                            -->
    </body>
    
    
</html>
