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
    
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String FirstName) {
        this.firstname = FirstName;
    }
    private String lastname;
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String string){
        this.lastname = string;
    }
    private String email;
    public String getEmail(){
        return email;
    }
    public void setEmail(String string){
        this.email = string;
    }
    private String districtname;
    public String getDistrictname(){
        return firstname;
    }
    public void setDistrictname(String string){
        this.districtname = string;
    }
    
    private String phone;
    public String getPhone(){
        return phone;
    }
    public void setPhone(String string){
        this.phone = string;
    }
    
    private String fax;
    public String getFax(){
        return fax;
    }
    public void setFax(String string){
        this.fax = string;
    }
    
    private String password;
    public String getPassword(){
        return password;
    }
    public void setPassword(String string){
        this.password = string;
    }
    private String confirmpassword;
    public String getConfirmpassword(){
        return confirmpassword;
    }
    public void setConfirmpassword(String string){
        this.confirmpassword = string;
    }
    private String error;
    //  private int number;

    /**
     * @return
     */

    
    public String getError(){
        return error;
    }
    
    public void setError(){
        this.error = 
                "<span style='color:red'>Please provide valid entries.'</span>";
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
        if (getFirstname() == null || getFirstname().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
