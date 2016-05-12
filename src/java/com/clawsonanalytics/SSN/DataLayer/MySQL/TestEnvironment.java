/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.DataLayer.MySQL;

import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataConnector;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;

import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.SSN.ModelLayer.User;
import java.sql.SQLException;

import java.util.List;
import java.lang.Runtime;
/**
 *
 * @author andrewclawson
 */
public class TestEnvironment {
    public MySQLManager mysqlManager = new MySQLManager();
    
    
    public TestEnvironment() {
        
        //Set Test mode on MySQLDataSource class
        
        //Duplicate production DB
        
        //Select test DB
        
    }
    
    public void Setup(String command){
        
        //Set test mode
        mysqlManager.SetTestMode();
        
        // Duplicate model tables to mirror production db
    }
    
    public void CreateTestTableForModelByTablename(String aTablename){
        mysqlManager.SetTestMode();
        String createString;
        String firstDBString = MySQLDataSource.getTestDatabaseName() + "." + aTablename;
        String secondDBString = MySQLDataSource.getDatabaseName() + "." +aTablename;
        createString = "CREATE TABLE " + firstDBString + " LIKE " + secondDBString + ";";
        mysqlManager.PrepareStatement(createString);
        try {
            //mysqlManager.getPreparedStatement().executeUpdate();
            mysqlManager.getPreparedStatement().execute(createString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
    
    public void DropTestTableForModelByTablename(String aTablename){
        String dropStatement = "DROP TABLE " + aTablename + ";";
        mysqlManager.PrepareStatement(dropStatement);
        try{
            mysqlManager.getPreparedStatement().executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        String useStatement = "USE " + MySQLDataSource.getDatabaseName()+";";
        try{
            mysqlManager.PrepareStatement(useStatement);
            mysqlManager.getPreparedStatement().executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
        
        //Select Test DB
        
    public void TearDown(){
        mysqlManager.SetProductionMode();
        
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
        try{
            mysqlManager.ExecuteQuery();
        }catch(SQLException e){
            
        }
    }
    
    private void DeleteTestDB(){
        
        /*
        String deleteString = "DROP " + MySQLDataSource.getTestDatabaseName() +";";
        mysqlManager.statementManager.setStatement(deleteString);
        mysqlManager.ExecuteQuery();
        */
    }
    
    
    
    
    
    
    
}
