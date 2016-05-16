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
    //private Statement statement;
    private String statementString;
    private Statement statement;
    private PreparedStatement preparedStatement;
    
    public StatementManager(){
        
    }
    
    public void setStatementString(String string){
        this.statementString = string;
    }
    
    
    public String getStatementString(){
        return this.statementString;
    }
    
    
    public void ChangeDBStatement(){
        this.statementString = "USE SSN_Application_Test";
    }
    
    public void setStatement(Statement aStatement){
        this.statement = aStatement;
    }
    
    public Statement getStatement(){
        return this.statement;
    }
    
    
    
    
}

