/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.UI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 *
 * @author andrewclawson
 */
@Controller
public class StartupController {
    
    public StartupController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @RequestMapping(value="/startup")
    public ModelAndView startup(HttpServletRequest request){
        HttpSession session = request.getSession();
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("startup/startup");
        session.setAttribute("dynamicContent", "/WEB-INF/views/startup/startup_content.jsp");
        
        return modelView;
    }
    
    @RequestMapping(value="/techsupport")
    public ModelAndView TechSupport(HttpServletRequest request){
        
        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("techsupport/techsupport");
        
        return modelView;
    }
}
