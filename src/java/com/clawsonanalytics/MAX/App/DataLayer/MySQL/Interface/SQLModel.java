/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface;

import com.clawsonanalytics.MAX.App.ModelLayer.Interface.IValidatable;
//import javax.sql.DataSource;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLDataSource;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SqlDAO;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        this.setID(0);
        
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
    
    public void setID(int id){
        ID = id;
    }
    
    
    public void SetIDBySQL(){
        int maxID = 0;
        String selectString = "SELECT * FROM " + getTablename() + ";";
        
        MySQLManager mysqlManager = new MySQLManager();
        
        try{
            mysqlManager.setResultSet(selectString);
            while (mysqlManager.getResultSet().next()){
                int newID = mysqlManager.getResultSet().getInt("id");
                if (newID > maxID){
                    maxID = newID;
                }
            }
        }catch(SQLException e){
            
        }
        
    }
    
    
    /*
    public static List<SQLModel> GetAll(){
        List<SQLModel> all = new ArrayList();
        
        
        return all;
    }*/
    /*
    public static int Count(){
        int count = 0;
        String selectString = "SELECT * FROM " + getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        mysqlManager.PrepareStatement(selectString);
        mysqlManager.ExecuteQuery();
        try{
            while(mysqlManager.getResultSet().next()){
                count = count + 1;
            }
        }catch (SQLException e){
            
        }
        return count; 
    }*/
    public void Insert(){
        
    }
    
    public void Update(){
        
    }
    
    public void Delete(){
        
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