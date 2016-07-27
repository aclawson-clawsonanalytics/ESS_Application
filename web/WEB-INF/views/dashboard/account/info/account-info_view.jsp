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
        
        <div class="small-10 large-10 ">
        <div class="tabs-content" data-tabs-content="account-info-tabs">
            <div class="tabs-panel" id="infoPanel">
                <form>
                    <table>
                        <tr>
                            <td colspan="1"><b>Account: </b></td>
                            <td colspan="3"><input type="text" name="accountName" value="${account.getName()}"></td>
                        </tr>
                        <tr>
                            <td colspan="1"><b>Open Date: </b></td>
                            <td colspan="3">${account.getCreationDate()}</td>
                        </tr>
                        <tr>
                            <td colspan="1"><b>Manager: </b></td>
                            <td colspan="1">
                                ${account.getManagerName()} <a class="button" id="ChangeManagerButton" onclick="showManagerSelector();">Change</a>
                            </td>
                            <td colspan="1">
                                
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
                <div class="small-10 large-8 columns">
                    <div class="row">
                        <select id="campus-selector">
                            <option value="-1">Select a campus</option>
                            <c:forEach var="campus" items="${campusList}">
                                <option value="${campus.getID()}">${campus.getName()}</option>
                                
                            </c:forEach>
                            <option value="0">Add new campus</option>
                        </select>
                    </div>
                    <form>
                                <table>
                                    <tr>
                                        <td colspan="1"><b>Campus</b></td>
                                        <td colspan="3"> <input type="text" name="campusName" id="campusInfoNameField"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>Address</td>
                                        <td colspan="3"> <input type="text" name="campusAddress" id="campusInfoAddressField"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>City</b></td>
                                        <td colspan="3"> <input type="text" name="campusCity" id="campusInfoCityField">
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>State</b></td>
                                        <td colspan="2"><input type="text" name="campusState" id="campusInfoStateField"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>Zip</b></td>
                                        <td colspan="2"><input type="text" name="campusZip" id="campusInfoZipField"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1"><b>P.O. Box</b></td>
                                        <td colspan="3"><input type="text" name="campusPO" id="campusInfoPOField"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="1" text-centered><a id="clearCampusInfoButton" class="button">Clear</a></td>
                                        <td colspan="1" text-centered><a id="saveCampusInfoButton" class="button">Save Campus</a></td>
                                        <td colspan="1" text-centered><a id="addCampusButton" class="button">Add Campus</a></td>
                                    </tr>
                                </table>
                            </form>
                        
                    
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
