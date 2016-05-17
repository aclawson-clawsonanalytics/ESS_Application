/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
/**
 *
 * @author andrewclawson
 */
@Controller
public class RegistrationController {
    @RequestMapping(value="/subscribe")
    public String RequestSubscription(){
        return "/registration_request/registrationRequest";
    }
    
    @RequestMapping(value="/submitRegistration")
    public String SubmitRegistration(){
        return "/registration_request/submissionSuccess";
    }
}
