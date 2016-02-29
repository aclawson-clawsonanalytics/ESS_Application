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

/**
 *
 * @author andrewclawson
 */
public class RegistrationFormAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String VALID_REGISTRATION = "valid_registration";
    private static final String MISSING_FIELDS_FAILURE = "missing_fields";
    private static final String INVALID_EMAIL_FAILURE = "invalid_email";
    private static final String DUPLICATE_REGISTRATION_FAILURE = "duplicate_registration";
    private static final String UNCONFIRMED_PASSWORD = "unconfirmed_password";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
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
            return mapping.findForward(MISSING_FIELDS_FAILURE);
        }
        if (!password.equals(confirmpassword)){
            return mapping.findForward(UNCONFIRMED_PASSWORD);
        }
        return mapping.findForward(VALID_REGISTRATION);
    }
}
