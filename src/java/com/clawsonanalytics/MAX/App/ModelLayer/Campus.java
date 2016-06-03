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
    
    public Campus(){
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
