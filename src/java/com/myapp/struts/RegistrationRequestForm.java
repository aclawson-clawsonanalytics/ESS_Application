/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author andrewclawson
 */
public class RegistrationRequestForm extends org.apache.struts.action.ActionForm {
    
    private String FirstName;
    private String LastName;
    private String Email;
    private String DistrictName;
    private String Phone;
    private int number;

    /**
     * @return
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param string
     */
    public void setFirstName(String string) {
        FirstName = string;
    }

    public String getLastName(){
        return LastName;
    }
    
    public void setLastName(String string){
        LastName = string;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String string){
        Email = string;
    }
    
    public String getDistrictName(){
        return DistrictName;
    }
    
    public void setDistrictName(String string){
        DistrictName = string;
    }
    
    public String getPhone(){
        return Phone;
    }
    
    public void setPhone(String string){
        Phone = string;
    }

    /**
     *
     */
    public RegistrationRequestForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getFirstName() == null || getFirstName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
