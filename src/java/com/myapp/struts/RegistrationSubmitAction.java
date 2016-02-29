/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.myapp.struts.RegistrationRequestForm;

/**
 *
 * @author andrewclawson
 */
public class RegistrationSubmitAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @
     * return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // Extract registration data
        RegistrationRequestForm requestForm = (RegistrationRequestForm) form;
        String firstname = requestForm.getFirstname();
        String lastname = requestForm.getLastname();
        String email = requestForm.getEmail();
        String districtname = requestForm.getDistrictname();
        String phone = requestForm.getPhone();
        String fax = requestForm.getFax();
        String password = requestForm.getPassword();
        String confirmpassword = requestForm.getConfirmpassword();
        
        if (firstname == null ||
                lastname == null ||
                email == null ||
                districtname == null ||
                phone == null ||
                password == null ||
                confirmpassword == null){
            requestForm.setError();
            return mapping.findForward(FAILURE);
        }
        if (!password.equals(confirmpassword)){
            return mapping.findForward(FAILURE);
        }
        return mapping.findForward(SUCCESS);
    }
}
