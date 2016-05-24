<%-- 
    Document   : dashboard_topbar
    Created on : May 18, 2016, 11:30:23 PM
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
<div class="top-bar">
    >
  <div class="top-bar-left">
    <ul class="dropdown menu" data-dropdown-menu>
        <li class="menu-text">MAX School Solutions</li>
      <li>
        <a href="#">District Administration</a>
        <ul class="menu vertical">
          <li><a href="#">District Data</a></li>
          <li><a href="#">District Settings</a></li>
          <li><a href="#">Student Data</a></li>
        </ul>
      </li>
      <li><a href="#">Administration</a>
        <ul class="menu vertical">
            <li><a href="#">School Settings</a></li>
            <li><a href="#">School Data</a></li>
            <li><a href="#">School Schedule</a></li>
            <li><a href="#">Student Information</a></li>
            <li><a href="#">Student Data</a></li>
        </ul>
      </li>
      <li><a href="#">Instructor</a>
        <ul class="menu vertical">
            <li><a onclick="LoadGradebook();">Gradebook</a></li>
            <li><a href="#">Attendance</a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Email</a></li>
        </ul>
      </li>
    </ul>
  </div>
  <div class="top-bar-right">
    <ul class="menu">
        <!--
      <li><input type="search" placeholder="Search"></li>
      <li><button type="button" class="button">Search</button></li>
        -->
      <li>${pageContext.session.getAttribute("loginUser").getEmail()}</li>
      <li><button type="button" class="button">Tech Support</button></li>
      <li><button type="button" class="button">Log out</button></li>
    </ul>
  </div>
</div>


