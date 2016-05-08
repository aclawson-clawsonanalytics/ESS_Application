/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL.Interface;

import com.clawsonanalytics.SSN.ModelLayer.Interface.IValidatable;
//import javax.sql.DataSource;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SqlDAO;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author andrewclawson
 */
public class SQLModel implements SqlDAO, IValidatable {
    // class members
    private static List<String> RegisteredModels;
    private static String tablename;
    
    private static String modelName;
    
    private int ID;
    
    
    
    // Constructor
    public SQLModel(){
        
        
    }
    
    public static void setTablename(String string){
        
        tablename = string;
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    
    public static void setModelName(String string){
        modelName = string;
    }
    
    public static String getModelName(){
        return modelName;
    }
    
    
    public SQLModel GetByID(int id){
        
        return this;
    }
    
    public void Insert(){
        
    }
    
    public void Update(){
        
    }
    
    public void Delete(){
        
    }
    
    public void WriteObject(){
        
    }
    
    public void MapRowToObject(ResultSet result){
        
    }
    
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = null;
        
        return _validationErrors;
    }
    
    public boolean IsValid(){
        if (this.GetValidationErrors().isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}