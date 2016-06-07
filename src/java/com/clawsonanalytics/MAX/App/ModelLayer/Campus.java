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
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author andrewclawson
 */
public class Campus extends SQLModel {
    
    // class properties
    private static String tablename = "CAMPUS";
    private static String modelname = "Campus";
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String po_box;
    
    private int account_id; // Foreign key reference to account
    private int principal_id; // Foreign key reference to user who is principal
    private int assistantPrincipal_id; // Foreign key reference ot user who is assistant principal.
    
    private Date creation_date;
    private Date close_date;
    
    public Campus() {
        foreignKeyRelations.add(Account.class);
    }
    
    public static String getTablename(){
        return tablename;
    }
    
    public void setName(String string){
        this.name = string;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setCity(String string){
        this.city = string;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public void setState(String string){
        this.state = string;
    }
    
    public String getState(){
        return this.state;
    }
    
    public void setZip(String string){
        this.zip = string;
    }
    
    public String getZip(){
        return this.zip;
    }
    
    public void setPO(String string){
        this.po_box = string;
    }
    
    public String getPO(){
        return this.po_box;
    }
    
    
    public static int Count(){
        int count = 0;
        ResultSet results;
        Statement statement;
        String selectString = "SELECT * FROM "+  getTablename() + ";";
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while (results.next()){
                count = count + 1;
            }
        }catch(SQLException e){
            
        }
        return count;
    }
    
    public static List<Campus> GetAll(){
        List<Campus> all = new ArrayList<Campus>();
        String selectString = "SELECT * FROM " + Campus.getTablename() + ";";
        MySQLManager mysqlManager = new MySQLManager();
        Statement statement;
        ResultSet results;
        MySQLManager mysql = new MySQLManager();
        try{
            statement = mysql.Connector.getConnection().createStatement();
            results = statement.executeQuery(selectString);
            while(results.next()){
                Campus newCampus = Campus.MapRowToObject(results);
                all.add(newCampus);
            }
        }catch(SQLException e){
            
        }
        
        return all;
    }
    @Override
    public void Insert(){
        if(this.IsValid()){
            String insertString = "INSERT INTO " + getTablename()
                    + " VALUES (?,?,?,?,?,?,?);";
            MySQLManager mysql = new MySQLManager();
            PreparedStatement preparedStatement;
            ResultSet keys;
            try{
                preparedStatement = mysql.Connector.getConnection().prepareStatement(insertString,Statement.RETURN_GENERATED_KEYS);
                preparedStatement = PrepareStatementForInsert(preparedStatement);
                int rowsUpdated = preparedStatement.executeUpdate();
                keys = preparedStatement.getGeneratedKeys();
                keys.next();
                int id = keys.getInt(1);
                this.setID(id);
                mysql.Connector.CloseResources();
            }catch(SQLException e){
                e.getMessage();
            }
        }
    }
    
    private PreparedStatement PrepareStatementForInsert(PreparedStatement preparedStatement){
        try{
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,this.getName());
            preparedStatement.setString(3,this.getAddress());
            preparedStatement.setString(4,this.getCity());
            preparedStatement.setString(5,this.getState());
            preparedStatement.setString(6,this.getZip());
            preparedStatement.setString(7,this.getPO());
        }catch(SQLException e){
            
        }
        
        return preparedStatement;
    } 
    private static Campus MapRowToObject(ResultSet results){
        Campus newCampus = new Campus();
        
        return newCampus;
    }
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if (this.getName() == null){
            _validationErrors.add("Campus must have a name.");
        }
        if (this.getAddress() == null){
            _validationErrors.add("Campus must have an address.");
        }
        
        if (this.getCity() == null){
            _validationErrors.add("Campus must have a city.");
        }
        
        if(this.getState() == null){
            _validationErrors.add("Campus must have a state.");
        }
        
        if (this.getZip() == null){
            _validationErrors.add("Campus must have a zip code.");
        }
        return _validationErrors;
    }
}
