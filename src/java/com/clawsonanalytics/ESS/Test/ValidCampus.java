/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Test;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Campus;
/**
 *
 * @author andrewclawson
 */
public class ValidCampus  extends Campus {
    public ValidCampus(){
        this.setName("sutName");
        this.setAddress("sutAddress");
        this.setCity("sutCity");
        this.setState("sutState");
        this.setZip("sutZip");
        this.setPO("sutPO");
    }
}
