/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.Academics.ModelLayer;

import com.clawsonanalytics.ESS.App.ModelLayer.Interface.IValidatable;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User;

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
public class Course extends SQLModel {
    private static String tablename = "COURSES";
    private int REFERENCE_ID;
    private int TERM_ID;
    
    private int PrimaryInstructorID;
    private int SecondaryInstructorID;
    
    private int is_active;
    
    public Course(){
        
    }
    
    public static String getTablename(){
        return Course.tablename;
    }
    
    public void setPrimaryID(int primaryInstructorID){
        this.PrimaryInstructorID = primaryInstructorID;
    }
    
    public int getPrimaryID(){
        return this.PrimaryInstructorID;
    }
    
    public User getPrimaryInstructor(){
        User primary = new User();
        
        return primary;
    }
    
    public void setSecondaryID(int secondaryInstructorID){
        this.SecondaryInstructorID = secondaryInstructorID;
    }
    
    public int getSecondaryInstructorID(){
        return this.SecondaryInstructorID;
    }
    
    
    @Override
    public List<String> GetValidationErrors(){
        List<String> _validationErrors = new ArrayList<String>();
        if (this.PrimaryInstructorID == 0 || getPrimaryInstructor() == null){
            _validationErrors.add("Course must have a primary instructor.");
        }
        return _validationErrors;
    }
    
    
    
    
}
