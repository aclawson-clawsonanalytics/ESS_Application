/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL;

import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLManager.SQLExecutor;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataConnector;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;

import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;

import java.sql.SQLException;

import java.util.List;
import java.lang.Runtime;
/**
 *
 * @author andrewclawson
 */
public class TestEnvironment {
    private MySQLManager mysqlManager = new MySQLManager();
    
    public TestEnvironment() {
        
        //Set Test mode on MySQLDataSource class
        
        //Duplicate production DB
        
        //Select test DB
        
    }
    
    public void Setup(String command){
        String createStatement;
        //Set test mode
        mysqlManager.SetTestMode();
        
        
    }
        
        //Select Test DB
        
    public void TearDown(){
        
    }
    
    
    
    
    
    
    private void DuplicateDatabaseStructure(){
        //mysqlManager.statementManager.setStatement(());
        try{
            
            //SQLExecutor executor = new SQLExecutor("SetupTestEnvironment.sql;");
            //executor.ExecuteScript();
            //Runtime.getRuntime().exec(ConstructMySQLDumpCommandNoData());
            //Runtime.getRuntime().exec(ConstructRestoreDBCommand());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
  
    private void DuplicateDatabaseWithData(){
        try{
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void UseTestDB(){
        // Create String for select command
        String selectString = "USE " + MySQLDataSource.getTestDatabaseName() +";";
        //Add string to mysqlManager.statementManager
        mysqlManager.statementManager.setStatementString(selectString);
        mysqlManager.ExecuteQuery();
    }
    
    private void DeleteTestDB(){
        /*
        String deleteString = "DROP " + MySQLDataSource.getTestDatabaseName() +";";
        mysqlManager.statementManager.setStatement(deleteString);
        mysqlManager.ExecuteQuery();
        */
    }
    
    
    
    
    
    
    
}
