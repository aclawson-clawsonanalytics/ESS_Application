/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.ModelLayer.Lists;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User;

import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewclawson
 */
public class CampusList {
    //private static List<Campus> allCampuses = Campus.GetAll();
    public String SELECT;
    public ArrayList<Campus> SET = new ArrayList<Campus>();
    public CampusList(){
        
    }
    
    /*Overloaded constructor for account*/
    public CampusList(Account account){
        SELECT = "SELECT * FROM " + Account.getTablename() + " WHERE account_id = " + account.getID() + ";";
    }
    
    public void Load(){
        // Create MySQLManager
        MySQLManager mysql = new MySQLManager();
        
        //Set SQL variables
        Statement statement;
        ResultSet results;
        
        // Execute statement
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(SELECT);
            while(results.next()){
                AddCampus(Campus.MapRowToObject(results));
            }
        }catch(SQLException e){
            
        }
        //Process results
        
        //Close resourecs
    }
    public void AddCampus(Campus campus){
        // TODO Check if campus already exists within list
        // TODO If campus is not persisted, insert it and 
        SET.stream().forEach((_campus) -> {
            if(_campus.getID() == campus.getID()){
                return;
            }else{
                if(campus.getID() == 0){
                    campus.Insert();
                    SET.add(campus);
                }
            }
        });
      
            
        }
        
}    
      
    
