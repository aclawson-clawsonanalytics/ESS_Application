<%-- 
    Document   : dashboard_menu_data
    Created on : Jun 10, 2016, 1:59:12 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/foundation.css"/>
<link rel="stylesheet" href="styles/foundation-6.2.1-complete/css/app.css"/>
<!DOCTYPE html>
                    <!-- Check if user is an account manager -->
                    <c:if test="${pageContext.session.getAttribute('activeUser').IsAccountManager()}">
                        <li>
                            <a>Account Admin</a>
                            <ul class="menu vertical" data-accordion>
                                <li><a>Management</a></li>
                                <li><a>Data</a></li>
                                <li><a>Finances</a></li>
                                
                            </ul>
                        </li>
                    </c:if>
                        
                    <!-- Check if user is school administration role -->
                    <c:if test="${pageContext.session.getAttribute('activeUser').IsSchoolAdmin()}">
                        <li>
                            <a>School Admin</a>
                            <ul class="menu vertical" data-accordion>
                                <li><a>Personnel</a></li>
                                <li><a>Curriculum</a></li>
                                <li><a>Data</a></li>
                                <li><a>Academics</a></li>
                            </ul>
                        </li>
                        
                    </c:if>
                            
                    <!-- Check if user is an instructor -->
                    <c:if test="${pageContext.session.getAttribute('activeUser').IsInstructor()}">
                        <li>
                            <a>Instructor</a>
                            <ul class="menu vertical" data-accordion>
                                <li><a>Gradebook</a></li>
                                <li><a>Attendance</a></li>
                                <li><a>Student Data</a></li>
                                <li><a>Report Cards</a></li>
                            </ul>
                        </li> 
                    </c:if>
