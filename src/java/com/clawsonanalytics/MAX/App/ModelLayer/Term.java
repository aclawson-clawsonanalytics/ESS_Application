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
    private int school_year;
    private int account_id;
    private Date start_date;
    private Date end_date;
    
    public Term(){
        
    }
    
    public void setStartDate(Date date){
        
    }
    
}
