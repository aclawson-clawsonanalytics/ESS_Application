/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Test;

import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.Test.ValidAccount;
import com.clawsonanalytics.ESS.Test.ValidCampus;
/**
 *
 * @author andrewclawson
 */
public class Entity {
    private Account account = new ValidAccount();
    private Campus campus = new ValidCampus();
    private User accountManager = new ValidUser();
    private User principal = new ValidUser();
    
    public Entity(){
        account.Insert();
        campus.Insert();
        campus.setAccountID(account.getID());
        accountManager.setAccountID(account.getID());
        accountManager.SetupAsManager();
        account.setManager(accountManager.getID());
        accountManager.Update();
        account.Update();
        
        principal.setAccountID(account.getID());
        principal.SetupAsSchoolAdmin();
        principal.Update();
        
        
    }
    
    public Account Account(){
        return this.account;
    }
    
    public Campus Campus(){
        return this.campus;
    }
    
    public User AccountManager(){
        return this.accountManager;
    }
    public User Principal(){
        return this.principal;
    }
}
