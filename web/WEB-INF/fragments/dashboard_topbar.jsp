<%-- 
    Document   : dashboard_topbar
    Created on : Jun 10, 2016, 1:26:37 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="off-canvas-wrapper">
        <div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>
            
            <!-- Define:
                1. Title bar for small screen
                2. Data content of hidden menu
                3. Wide screen menu 
                4. Content display
            
            <!--Off-canvas title bar for small screen-->
            <div class="title-bar" data-responsive-toggle="dashboardWideMenu" data-hide-for="medium">
                <div class="title-bar-left">
                    <button class="menu-icon" type="button" data-toggle="mobileDashboardMenu"></button>
                    <span class="title-bar-title">Menu</span>
                </div>
            </div>
            
            
            <!-- Data content of hidden menu -->
            <div class="off-canvas position-left" id="mobileDashboardMenu" data-off-canvas>
                <ul class="vertical accordion-menu menu" data-accordion-menu>
                    <jsp:include page="/WEB-INF/views/dashboard/dashboard_menu_data.jsp"/>
                    <li><br><br></li>
                    <jsp:include page="/WEB-INF/views/dashboard/dashboard_menu_utility_options.jsp"/>
                </ul>
                
            </div>
            
            
            <!-- Wide menu -->
            <div id="dashboardWideMenu" class="top-bar">
                <div class="top-bar-left">
                    <ul class="dropdown menu" data-dropdown-menu>
                        <jsp:include page="/WEB-INF/views/dashboard/dashboard_menu_data.jsp"/>
                    </ul>
                </div>
                    
                    <div class="top-bar-right">
                        <ul class="menu">
                            <jsp:include page="/WEB-INF/views/dashboard/dashboard_menu_utility_options.jsp"/>
                        </ul>
                    </div>
            </div> <!-- End wide menu -->
            
            <div class="off-canvas-content" data-off-canvas-content>
      <div class="row column dashboard_content">
          DASHBOARD CONTENT COMING SOON
      </div>
    </div>
        </div>
    </div>
</html>
