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

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
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
    
    public void Setup(){
        
        //Set test mode
        mysqlManager.SetTestMode();
        this.UseTestDB();
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
        
        //mysqlManager.PrepareStatement(dropStatement);
        try{
            Statement statement = mysqlManager.Connector.getConnection().createStatement();
            statement.executeQuery(dropStatement);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        /*
        String useStatement = "USE " + MySQLDataSource.getDatabaseName()+";";
        try{
            mysqlManager.PrepareStatement(useStatement);
            mysqlManager.getPreparedStatement().executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        */
    }
    
    public void DropRecordsForTestTable(String aTablename){
        String dropStatement = "TRUNCATE " + aTablename + ";";
        
        try{
            Statement statement = mysqlManager.Connector.getConnection().createStatement();
            statement.executeQuery(dropStatement);
        }catch(SQLException e){
            
        }
        
    }
        
        //Select Test DB
        
    public void TearDown(){
        mysqlManager.SetProductionMode();
        this.UseProductionDB();
        //mysqlManager.Connector.CloseResources();
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
        try{
            Statement statement = mysqlManager.Connector.getConnection().createStatement();
            statement.executeQuery(selectString);
        }catch(SQLException e){
            
        }
        //Add string to mysqlManager.statementManager
        
    }
    
    private void UseProductionDB(){
        String selectString = "USE " + MySQLDataSource.getDatabaseName() + ";";
        try{
            Statement statment = mysqlManager.Connector.getConnection().createStatement();
            statment.executeQuery(selectString);
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
