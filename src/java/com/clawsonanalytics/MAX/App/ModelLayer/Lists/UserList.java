/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer.Lists;

import com.clawsonanalytics.MAX.App.ModelLayer.User;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public class UserList extends ArrayList {
    
    private static List<User> allUsers = User.GetAll();
    //private String criteria;
    
    public UserList() {
        
    }
    
    
    public void add(User user){
        if(user.IsValid()){
            user.Insert();
        }
        super.add(user);
    }
    
    public static List<User> ByAccount(int accountID){
        
        List<User> usersByAccount = new ArrayList<> ();
        for(User user : allUsers){
            if (user.getAccountID() == accountID){
                usersByAccount.add(user);
            }
        }
        
        return usersByAccount;
    }
    
    
}
