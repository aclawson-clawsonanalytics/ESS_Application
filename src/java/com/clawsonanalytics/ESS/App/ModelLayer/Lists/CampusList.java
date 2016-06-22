/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.ModelLayer.Lists;
import com.clawsonanalytics.ESS.App.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewclawson
 */
public class CampusList extends ArrayList {
    private static List<Campus> allCampuses = Campus.GetAll();
    
    public CampusList(){
        
    }
    
    public void add(Campus campus){
        if (campus.IsValid()){
            campus.Insert();
        }
        super.add(campus);
    }
    
    public static List<Campus> ByAccount(int accountID){
        List<Campus> campusesByAccount = new ArrayList<Campus>();
        for (Campus campus : allCampuses){
            if (campus.getAccountID() == accountID){
                campusesByAccount.add(campus);
            }
        }
        return campusesByAccount;
    }
}
