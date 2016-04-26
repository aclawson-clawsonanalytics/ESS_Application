/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.ModelLayer;
import java.util.ArrayList;
import Core.Database.SQLModel;

/**
 *
 * @author andrewclawson
 */
public class User extends SQLModel {
    // Class variables
    //public String TableName = "User";
    
    
    // Constructor
    public User(){
        
    }
    
    @Override
    public void Save(){
        
    }
    
    @Override
    public void Delete(){
        
    }
    
    @Override
    public ArrayList GetAll(){
        ArrayList _userObjects = new ArrayList<User> ();
        return _userObjects;
    }
    
    
    
    
}
