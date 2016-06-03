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
    
    
}
