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
        
        <div class="small-10 small-centered large-10 large-centered">
        <div class="tabs-content" data-tabs-content="account-info-tabs">
            <div class="tabs-panel" id="infoPanel">
                <form>
                    <table>
                        <tr>
                            <td><b>Account: </b></td>
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
                                    <c:forEach var="user" items="${userList}">
                                        <option value="${user.getID()}">${user.getFirstname()} ${user.getLastname()}</option>
                                    </c:forEach>
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
                <div class="small-10 small-centered large-8 large-centered">
                    
                        <c:forEach var="campus" items="${campusList}">
                           
                            <form>
                                <table>
                                    <tr>
                                        <td colspan="1">Campus</td>
                                        <td colspan="3"> <input type="text" value="${campus.getName()}"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>Address</td>
                                        <td colspan="3"> <input type="text" value="${campus.getAddress()}"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>City</b></td>
                                        <td colspan="3"> <input type="text" value="${campus.getCity()}">
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>State</b></td>
                                        <td colspan="2"><input type="text" value="${campus.getState()}"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>Zip</b></td>
                                        <td colspan="2"><input type="text" value="${campus.getZip()}"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>P.O. Box</b></td>
                                        <td colspan="3"><input type="text" value="${campus.getPO()}"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" text-centered><a class="button">Reset</a></td>
                                        <td colspan="2" text-centered><a class="button">Save Changes</a></td>
                                    </tr>
                                </table>
                            </form>
                            
                        </c:forEach>
                    
                </div>
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
