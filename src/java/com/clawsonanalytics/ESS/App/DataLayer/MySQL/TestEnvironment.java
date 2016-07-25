/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.DataLayer.MySQL;

import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLDataConnector;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.MySQLDataSource;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.User;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.AccountManagement.ModelLayer.Campus;

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
    public MySQLManager mysqlManager;
    
    
    public TestEnvironment() {
        
        //Set Test mode on MySQLDataSource class
        
        //Duplicate production DB
        
        //Select test DB
        
    }
    
    public void Setup(){
        mysqlManager = new MySQLManager();
        //Set test mode
        mysqlManager.SetTestMode();
        this.UseTestDB();
        // Duplicate model tables to mirror production db
    }
    
    
    
    public void CreateTestTableForModelByTablename(String aTablename){
        //mysqlManager.SetTestMode();
        String createString;
        String firstDBString = MySQLDataSource.getTestDatabaseName() + "." + aTablename;
        String secondDBString = MySQLDataSource.getDatabaseName() + "." +aTablename;
        createString = "CREATE TABLE " + firstDBString + " LIKE " + secondDBString + ";";
        
        try {
            //mysqlManager.getPreparedStatement().executeUpdate();
            Statement statement = mysqlManager.Connector.getConnection().createStatement();
            statement.execute(createString);
            //mysqlManager.getPreparedStatement().execute(createString);
        } catch (SQLException e) {
            
        }
            
    }
    
    public void DropTestTableForModelByTablename(String aTablename){
        String dropStatement = "DROP TABLE " + MySQLDataSource.getTestDatabaseName()+"."+aTablename + ";";
        
        //mysqlManager.PrepareStatement(dropStatement);
        try{
            Statement statement = mysqlManager.Connector.getConnection().createStatement();
            statement.execute(dropStatement);
            
        }catch(SQLException e){
            //e.printStackTrace();
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
            statement.execute(dropStatement);
        }catch(SQLException e){
            
        }
        
    }
        
        //Select Test DB
        
    public void TearDown(){
        mysqlManager.SetProductionMode();
        this.UseProductionDB();
        mysqlManager.Connector.CloseResources();
    }
    
    
    
    
    
    
    private void DuplicateDatabaseStructure(){
        //mysqlManager.statementManager.setStatement(());
        try{
            
            //SQLExecutor executor = new SQLExecutor("SetupTestEnvironment.sql;");
            //executor.ExecuteScript();
            //Runtime.getRuntime().exec(ConstructMySQLDumpCommandNoData());
            //Runtime.getRuntime().exec(ConstructRestoreDBCommand());
        }catch (Exception e){
            //e.printStackTrace();
        }
    }
  
    private void DuplicateDatabaseWithData(){
        try{
            
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    
    private void UseTestDB(){
        // Create String for select command
        String selectString = "USE " + MySQLDataSource.getTestDatabaseName() +";";
        try{
            //Statement statement = mysqlManager.Connector.getConnection().createStatement();
            //statement.executeUpdate(selectString);
            mysqlManager.Connector.getConnection().setCatalog(MySQLDataSource.getTestDatabaseName());
        }catch(SQLException e){
            
        }
        //Add string to mysqlManager.statementManager
        
    }
    
    private void UseProductionDB(){
        String selectString = "USE " + MySQLDataSource.getDatabaseName() + ";";
        try{
            //Statement statment = mysqlManager.Connector.getConnection().createStatement();
            //statment.execute(selectString);
            mysqlManager.Connector.getConnection().setCatalog(MySQLDataSource.getDatabaseName());
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
    
    public void CreateTablesForEntity(){
        // - Users
        CreateTestTableForModelByTablename(User.getTablename());
        // - Accounts
        CreateTestTableForModelByTablename(Account.getTablename());
        // - Campus
        CreateTestTableForModelByTablename(Campus.getTablename());
        // - 
    }
    
    public void DropForEntity(){
        // Drop records
        
        DropRecordsForTestTable(User.getTablename());
        DropRecordsForTestTable(Account.getTablename());
        DropRecordsForTestTable(Campus.getTablename());
        
        DropTestTableForModelByTablename(Campus.getTablename());
        DropTestTableForModelByTablename(User.getTablename());
        DropTestTableForModelByTablename(Account.getTablename());
        
    }
    
    
    
    
    
}
