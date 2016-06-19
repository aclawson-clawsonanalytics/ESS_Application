/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.ModelLayer.Academics;
import com.clawsonanalytics.MAX.App.DataLayer.MySQL.Interface.SQLModel;
/**
 *
 * @author andrewclawson
 */
public class Course extends SQLModel {
    private static String tablename = "COURSES";
    
    public Course(){
        
    }
    
    public static String getTablename(){
        return Course.tablename;
    }
    
}
