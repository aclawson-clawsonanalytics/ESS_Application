/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
import java.sql.Date;
/**
 *
 * @author andrewclawson
 */
public class Term extends SQLModel {
    private String school_year;
    private int account_id;
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
    
    public Account Account(){
        return Account.GetByID(this.account_id);
    }
    
    
    
}
