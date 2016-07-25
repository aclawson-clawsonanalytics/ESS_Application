/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.ModelLayer.Managers;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Account;

import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public class CampusManager {
    
    public ArrayList<Campus> CampusSet;
    public Account account;
    public CampusManager(Account _account){
        this.account = _account;
    }
    
    public void LoadCampusSet(){
        
    }
    
}
