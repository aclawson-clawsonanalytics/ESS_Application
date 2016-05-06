/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.ModelLayer;
import java.util.List;
//import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel__;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SqlDAO;

/**
 *
 * @author andrewclawson
 */
public class User extends SQLModel {
    
    
    
    // Constructor
    public User() {
        User.setTablename("USERS");
        User.setModelName(User.class.getSimpleName());
    }
    
    
    //SQL DAO methods
    @Override
    public void GetByID(int id){
        
    }
    
    @Override
    public void Insert(){
        
    }
    
    @Override
    public void Update(){
        
    }
    
    @Override
    public void Delete(){
        
    }
    
    @Override
    public void WriteObject(){
        
    }
    
    @Override
    public void MapRowToObject(){
        
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = null;
        
        return _validationErrors;
    }
    
    
    
}
