/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer;
import com.clawsonanalytics.MAX.App.ModelLayer.Interface.IValidatable;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.MySQLManager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public class Account extends SQLModel {
    
    // member variables
    // static variables
    private static String tablename = "ACCOUNTS";
    private static String modelname = "Account";
    
    // non-static variables
    private int manager_id;
    private String name;
    private Date creation_date;
    private Date close_date;
    
    private User manager;
    // Constructor
    public Account(){
        //this.setManager(managerID);
        //this.setManager(managerID);
        this.setCreationDate();

        
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public void setManager(int managerID){
        this.manager_id = managerID;
        this.LoadManager();
    }
    
    public int getManagerID(){
        return this.manager_id;
    }
    
    public void LoadManager(){
        try{
            manager = User.GetByID(this.manager_id);
        }catch(Exception e){
            manager = null;
        }
        
    }
    
    public void setManager(User _manager){
        this.manager = _manager;
    }
    public User Manager(){
        return manager;
    }
    
    public void setName(String string){
        this.name = string;
    }
    
    public String getName(){
        return this.name;
    }
    private void setCreationDate(){
        this.creation_date = new Date(Calendar.getInstance().getTime().getTime());
    }
    public Date getCreationDate(){
        return this.creation_date;
    }
    
    public void setCloseDate(){
        this.close_date = new Date(Calendar.getInstance().getTime().getTime());
    }
    
    public Date getCloseDate(){
        return this.close_date;
    }
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        
        if (this.getName() == null){
            _validationErrors.add("Account must have a name.");
        }
        
        return _validationErrors;
    }
    public static int Count(){
        int count = 0;
        ResultSet results;
        Statement statement;
        String selectString = "SELECT * FROM " + Account.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        
        //mysqlManager.PrepareStatement(selectString);
        try{
            statement = mysqlManager.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            
            while(results.next()){
                count = count+1;
            }
            
        }catch(SQLException e){
            
        }
        return count;
    }
    
    public List<Account> GetAll(){
        List<Account> allAccounts = new ArrayList<Account>();
        String selectString = "SELECT * FROM " + Account.getTablename() +";";
        MySQLManager mysql = new MySQLManager();
        Statement statement;
        ResultSet results;
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                Account newAccount = new Account();
                
            }
        }catch(SQLException e){
            
            
        }
        return null;
    }
    public void Insert(){
        
        
    }
    
    
    
    
    
    
}
