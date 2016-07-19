/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.UI.Controllers;
import com.clawsonanalytics.ESS.App.UI.Controllers.StartupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.Campus;
/**
 *
 * @author andrewclawson
*/
@Controller
@SessionAttributes
public class DashboardController {
    public User activeUser;
    
    public DashboardController(){
        
    }
    
    @RequestMapping(value="/dashboard", method=RequestMethod.POST)
    public ModelAndView MainDashboardControl(HttpServletRequest request){
        HttpSession session = request.getSession();
        String email;
        String password;
        if(request.getParameter("loginEmail") != null && request.getParameter("loginPassword") != null){
            email = request.getParameter("loginEmail");
            password = request.getParameter("loginPassword");
        }
        else{
            email = request.getParameter("mobileLoginEmail");
            password = request.getParameter("mobileLoginPassword");
        }
        
        
        ModelAndView modelView = new ModelAndView();
        try{
            
            activeUser = User.GetByCredentials(email, password);
            
            if (activeUser != null){
                Account userAccount = Account.GetByID(activeUser.getAccountID());
                userAccount.OnLoad();
                modelView.setViewName("dashboard/dashboard");
                //modelView.addObject("activeUser",activeUser);
                
                session.setAttribute("activeUser", activeUser);
                
                
                
                
                //request.login(activeUser.getEmail(),activeUser.getPassword());
                
                
            }else{
                modelView.setViewName("redirect:startup.htm");
                //modelView.addObject("loginError","Invalid credentials");
                session.setAttribute("loginError", "Invalid credentials");
                
            }
            
        }catch(Exception e){
            modelView.setViewName("redirect:startup.htm");
            session.setAttribute("loginError",e.getMessage());
            
        }
        //return "dashboard/dashboard";
        return modelView;
    }
    
    @RequestMapping(value="/logout")
    public ModelAndView Logout(HttpServletRequest request){
        ModelAndView modelView = new ModelAndView();
        HttpSession session = request.getSession();
        try{
            //request.logout();
        }catch(Exception e){
            
        }
        session.removeAttribute("activeUser");
        session.removeAttribute("campus");
        session.removeAttribute("account");
        session.removeAttribute("loginError");
        activeUser = null;
        modelView.setViewName("redirect:startup.htm");
        /*
        try{
            request.logout();
        }catch(Exception e){
            
        }
        */
        /*
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("redirect:startup.htm");*/
        return modelView;
    }
    
    @RequestMapping(value="/dashboard-techsupport")
    public ModelAndView TechSupport(HttpServletRequest request){
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("dashboard/dashboard");
        modelView.addObject("dynamicContent","/WEB-INF/views/techsupport/fragments/techsupport_form.jsp");
        //request.setAttribute("dynamicContent", "/WEB-INF/views/techsupport/fragments/techsupport_form.jsp");
        return modelView;
    }
    
    @RequestMapping(value="/dashboard-gradebook")
    public ModelAndView Gradebook(HttpServletRequest request){
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("dashboard/dashboard");
        modelView.addObject("dynamicContent","/WEB-INF/views/dashboard/instructor/gradebook/gradebook_view.jsp");
        modelView.addObject("mobileMenu","/WEB-INF/views/dashboard/instructor/gradebook/fragments/mobile_menu.jsp");
        modelView.addObject("mobileMenuOptions","/WEB-INF/views/dashboard/instructor/gradebook/fragments/menu_options.jsp");
        
        return modelView;
    }
    
    @RequestMapping(value="/dashboard-account-info.htm")
    public ModelAndView Account(HttpServletRequest request){
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("dashboard/dashboard");
        modelView.addObject("dynamicContent","/WEB-INF/views/dashboard/account/info/account-info_view.jsp");
        modelView.addObject("mobileMenu","/WEB-INF/views/dashboard/account/info/fragments/mobile_menu.jsp");
        modelView.addObject("mobileMenuOptions","/WEB-INF/views/dashboard/account/info/fragments/menu_options.jsp");
        return modelView;
    }
} 
