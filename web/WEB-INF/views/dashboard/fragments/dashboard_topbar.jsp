<%-- 
    Document   : dashboard_topbar
    Created on : Jun 10, 2016, 1:26:37 PM
    Author     : andrewclawson
--%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="/WEB-INF/tlds/AppInformation.tld" prefix="app"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="off-canvas-wrapper">
    <div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>

    <!-- off-canvas title bar for 'small' screen -->
        <div class="title-bar" data-responsive-toggle="widemenu" data-hide-for="medium">
          <div class="title-bar-left">
            <button class="menu-icon" type="button" data-open="offCanvasLeft"></button>
            <span class="title-bar-title">Dashboard Menu</span>
          </div>
          <div class="title-bar-right">
              <!--
            <span class="title-bar-title">Login</span>
            <button class="menu-icon" type="button" data-toggle="offCanvasRight"></button>
              -->
          </div>
        </div>

    <!-- off-canvas left menu -->
        <div class="off-canvas position-left" id="offCanvasLeft" data-off-canvas>
            <button class="close-button" aria-label="Close menu" type="button" data-close>
                <span aria-hidden="true">&times;</span>
            </button>
            
          <ul class="vertical accordion-menu menu" data-accordion-menu>
              <li><br><br></li>
              
              <c:if test="${pageContext.session.getAttribute('activeUser').IsAccountManager()}">
              <li>
              
                  <a><b>Account Admin</b></a>
                  <ul class="menu vertical">
                      <li><a>Account Info</a></li>
                      <li><a>Manage Users</a></li>
                      <li><a>Account Settings</a></li>
                  </ul>
              
              </li>
              </c:if>
            
            
              
              
              <c:if test="${pageContext.session.getAttribute('activeUser').IsSchoolAdmin()}">
              <li>
                  <a href="#"><b>School Admin</b></a>
                <ul class="menu vertical">
                    <li><a>Personnel</a></li>
                    <li><a>Academics</a></li>
                    <li><a>Data</a></li>
                </ul>
                    
              </li>
              </c:if>
              
              <c:if test="${pageContext.session.getAttribute('activeUser').IsInstructor()}">
                  <li>
                      <a><b>Instructor</b></a>
                      <ul class="menu vertical">
                          <li><a>Grade Book</a></li>
                          <li><a>Attendance</a></li>
                          <li><a>Classes</a></li>
                          <li><a>Data</a></li>
                      </ul>
                  </li>
              </c:if>
                  
                  <li class="divider"><br><br></li>
                  
                  <li><a href="${pageContext.request.contextPath}/dashboard-techsupport.htm">Tech Support</a></li>
                  <li><a href="${pageContext.request.contextPath}/logout.htm">Logout</a></li>
          </ul>
           
        </div>

    <!-- off-canvas right menu -->
    <!--
        <div class="off-canvas position-right" id="offCanvasRight" data-off-canvas data-position="right">
          <ul class="vertical dropdown menu" data-dropdown-menu>
            <li><a href="right_item_1">Right item 1</a></li>
            <li><a href="right_item_2">Right item 2</a></li>
            <li><a href="right_item_3">Right item 3</a></li>
          </ul>
        </div>
    -->

    <!-- "wider" top-bar menu for 'medium' and up -->
    <div id="widemenu" class="top-bar">
      <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
          
          
          <c:if test="${pageContext.session.getAttribute('activeUser').IsAccountManager()}">
          <li data-toggle>
              <a><b>Account Admin</b></a>
            <ul class="menu vertical">
                <li data-close><a>Account Info</a></li>
                <li data-close><a>Manage Users</a></li>
                <li data-close><a>Settings</a></li>
            </ul>
          </li>
          </c:if>
          
          <c:if test="${pageContext.session.getAttribute('activeUser').IsSchoolAdmin()}">
          <li data-toggle>
              <a><b>School Admin</b></a>
            <ul class="menu vertical">
                <li data-close><a>Personnel</a></li>
                <li data-close><a>Academics</a></li>
              <li data-close><a>Data</a></li>
            </ul>
          </li>
          </c:if>
          
          <c:if test="${pageContext.session.getAttribute('activeUser').IsInstructor()}">
              <li data-toggle>
                  <a><b>Instructor</b></a>
                  <ul class="menu vertical">
                      <li data-close><a>Grade Book</a></li>
                      <li data-close><a>Attendance</a></li>
                      <li data-close><a>Classes</a></li>
                      <li data-close><a>Data</a></li>
                  </ul>
              </li>
          </c:if>
        </ul>
      </div>
        
        
      <div class="top-bar-right">
        <ul class="menu">
            <li><a id="techSupport" href="${pageContext.request.contextPath}/dashboard-techsupport.htm">Tech Support</a></li>
            <li><br></li>
            <li><a href="${pageContext.request.contextPath}/logout.htm">Logout</a></li>
        </ul>
      </div>
        
        
    </div>

    <!-- original content goes in this container -->
    <div class="off-canvas-content" data-off-canvas-content>
      <div id="dashboard_window" class="row column dashboard_content">
          <jsp:include page="/WEB-INF/views/dashboard/fragments/info_bar.jsp"/>
          <jsp:include page="${dynamicContent}"/>
      </div>
    </div>

  <!-- close wrapper, no more content after this -->
  </div>
</div>
        <script src="js/dashboard.js"></script>
</html>
