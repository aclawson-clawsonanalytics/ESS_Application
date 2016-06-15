/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author andrewclawson
 */
public class Term extends SQLModel {
    private String school_year;
    private int account_id;
    private String label;
    private Date start_date;
    private Date end_date;
    
    public Term(){
        
    }
    
    public void setYear(String year){
        this.school_year = year;
    }
    
    public String getYear(){
        return this.school_year;
    }
    public void setStartDate(Date date){
        this.start_date = date;
    }
    
    public Date getStartDate(){
        return this.start_date;
    }
    
    public void setEndDate(Date date){
        this.end_date = date;
    }
    
    public Date getEndDate(){
        return this.end_date;
    }
    
    public void setAccountID(int id){
        this.account_id = id;
    }
    
    public int getAccountID(){
        return this.account_id;
    }
    
    public void setLabel(String string){
        this.label = string;
    }
    
    public String getLabel(){
        return this.label;
    }
    public Account Account(){
        return Account.GetByID(this.account_id);
    }
    
    
    // Validation Methods
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if (null == this.getYear()){
            _validationErrors.add("Academic term must have a school year.");
        }
        
        if (this.getYear() ==  null){
            _validationErrors.add("Academic term must have a label.");
        }
        
        if ( !this.getStartDate().before(this.getEndDate())){
            _validationErrors.add("Check academic term dates.");
        }
        return _validationErrors;
    }
    
    
}
