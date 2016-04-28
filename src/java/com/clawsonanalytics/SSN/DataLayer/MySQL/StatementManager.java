/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author andrewclawson
 */
public class StatementManager {
    private String statement;
    
    public StatementManager(){
        
    }
    
    public void setStatement(String string){
        this.statement = string;
    }
    
    public String getStatement(String string){
        return this.statement;
    }
    
    
}

